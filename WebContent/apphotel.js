var show = function (elem) {
    elem.style.display = 'block';
};
var hide = function (elem) {
    elem.style.display = 'none';
};
var toggle = function (elem) {
    if (window.getComputedStyle(elem).display === 'block') {
        hide(elem);
        return;
    }
    else {
        show(elem);
    }
};
var selectVille = document.getElementById("city");
var gallery = document.querySelectorAll(".container .gallery");
selectVille.addEventListener("change", function () {
    if (selectVille.value == "All") {
        for (const item of gallery) {
            console.log(item.dataset.ville);
            show(item);
        }

    }
    else {
        for (const item of gallery) {
            console.log(item.dataset.ville);
            if (selectVille.value == item.dataset.ville) {
                show(item);
            }
            else {
                hide(item);
            }
        }
    }
});