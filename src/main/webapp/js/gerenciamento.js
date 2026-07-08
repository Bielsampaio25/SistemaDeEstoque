document.addEventListener("DOMContentLoaded", carregarProdutos);

async function carregarProdutos() {

    try {

        const resposta = await fetch("../api/estoque");

        if (!resposta.ok) {
            throw new Error("Erro ao buscar produtos do servidor.");
        }

        const produtos = await resposta.json();

        const tabela = document.getElementById("listaProdutos");
        const quantidadeTotal = document.getElementById("quantidadeTotalEstoque");

        tabela.innerHTML = "";

        let total = 0;
        let linhas = "";

        produtos.forEach(produto => {

            total += Number(produto.quantidade);

            let status = "";
            let acao = "";

            if (produto.quantidade > 20) {
                status = '<span class="badge status-ok">Estoque Adequado</span>';
                acao = "Nenhuma";
            } else if (produto.quantidade > 5) {
                status = '<span class="badge status-alerta">Reposição Necessária</span>';
                acao = "Monitorar níveis";
            } else {
                status = '<span class="badge status-critico">Estoque Crítico</span>';
                acao = '<button class="btn-comprar">Emitir Nota de Compra</button>';
            }

            linhas += `
                <tr>
                    <td>${produto.codigoBarras}</td>
                    <td>${produto.nomeProduto}</td>
                    <td>${produto.fabricante}</td>
                    <td>${produto.quantidade}</td>
                    <td>${status}</td>
                    <td>${acao}</td>
                </tr>
            `;

        });

        tabela.innerHTML = linhas;
        quantidadeTotal.textContent = `${total} unidades`;

    } catch (erro) {

        console.error("Erro ao carregar produtos:", erro);

        document.getElementById("listaProdutos").innerHTML = `
            <tr>
                <td colspan="6" style="text-align:center;">
                    Erro ao carregar os produtos.
                </td>
            </tr>
        `;

    }

}