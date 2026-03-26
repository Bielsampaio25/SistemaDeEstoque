document.addEventListener("DOMContentLoaded", function(){
    constcampoCep = document.getElementById("cep"); /*busque o elemento cep no HTML*/
    
    campoCep.addEventListener("blur", buscarCep); /*está vazio, armazene o valor na variavel buscarCep*/
    campoCep.addEventListener("keypress", function(e){
        if(e.key === "Enter"){ /*Quando o usuario clicar em Enter*/
            e.preventDefault(); /*será um padrão*/
            buscarCep(); /*busque o cep*/
        }
    });
});

async function buscarCep() {
    constcampoCep = document.getElementById("cep"); /*busque o elemento cep no HTML*/
    
    const cep = campoCep.value.replace(/\D/g, ""); /*trata o cep tirando os caracteres*/
    
    if(cep.length != 8){ /*se for diferente de 8 caracteres*/
        if(cep.length < 0){ /*se for menor que 0*/
            alert("O seu cep está incorreto!");
            limparCampoEndereco();
        }
        return;
    }
    campoCep.style.borderColor = '#aaa';
    preencherCampos({aguardando: true});
    
    try{
        const response = await fetch("https://viacep.com.br/ws/{cep}/json/");
        const dados =  await response.json();
        
        if(dados.erro) {
            alert("CEP não encontrado");
            limparCampoEndereco();
            campoCep.style.borderColor = "red";
        }
        
        preencherCampos(dados);
        campoCep.style.borderColor = "green";
        
        campoCep.value = cep.replace(/(\d{5})(\d{3})/, "$1-$2");
        
        document.getElementById("numero");
    }catch (error) {
        alert("verifique a conexão com a internet");
        limparCamposEndereco();
        campoCep.style.borderColor = "red";
        console.error('erro na busca do CEP: ', error);
    }
}