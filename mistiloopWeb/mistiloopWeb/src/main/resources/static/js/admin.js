const showFormBtn =
document.getElementById("showFormBtn");

const productForm =
document.getElementById("productForm");

showFormBtn.addEventListener("click", () => {

    if(productForm.style.display === "block"){
        productForm.style.display = "none";
    }else{
        productForm.style.display = "block";
    }

});

function increaseStock(){

    let stock =
    document.getElementById("stock");

    stock.value =
    parseInt(stock.value) + 1;
}

function decreaseStock(){

    let stock =
    document.getElementById("stock");

    if(parseInt(stock.value) > 0){

        stock.value =
        parseInt(stock.value) - 1;
    }
}

document.getElementById("categorySelect")
.addEventListener("change",function(){

    const newCategory =
    document.getElementById("newCategory");

    if(this.value === "NEW"){
        newCategory.style.display="block";
    }else{
        newCategory.style.display="none";
    }
});