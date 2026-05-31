document.addEventListener("DOMContentLoaded", function() {

    const shopNowButton = document.querySelector(".hero button");

    shopNowButton.addEventListener("click", function() {

        document.querySelector(".categories")
            .scrollIntoView({
                behavior: "smooth"
            });

    });

});