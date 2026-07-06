document.getElementById("valor").addEventListener("input", calcular);
document.getElementById("quantidade").addEventListener("input", calcular);

function calcular() {
    let valor = parseFloat(document.getElementById("valor").value) || 0;
    let quantidade = parseInt(document.getElementById("quantidade").value) || 0;

    let total = valor * quantidade;

    document.getElementById("total").value = total.toFixed(2);
}


