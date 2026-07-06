document.addEventListener("DOMContentLoaded", function() {
    const btnLogout = document.getElementById("btnLogout");
    if (!btnLogout) return;

    btnLogout.addEventListener("click", function(event) {
        event.preventDefault();
        window.location.href = window.location.origin + "/logout";
    });
});

