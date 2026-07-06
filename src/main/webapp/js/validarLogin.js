async function validarLogin() {
    try {
        const res = await fetch("/api/perfil");
        const dado = await res.json();

        console.log("PERFIL FRONT: ", dado.perfil);

        if (!dado.perfil || dado.perfil.toLowerCase() !== "admin") {
            const menus = document.getElementsByClassName("btn-menu");
            for (const menu of menus) {
                menu.style.display = "none";
            }
        }
    } catch (e) {
        console.error("Erro ao verificar o perfil.", e);
    }
}

validarLogin();