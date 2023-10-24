
const fileUpload = document.getElementById("file-upload");
const imagePreview = document.getElementById("image-preview");

fileUpload.addEventListener("change", function() {
    const file = this.files[0];
    const reader = new FileReader();

    reader.addEventListener("load", function() {
        const imageUrl = reader.result;
        const image = new Image();

        image.addEventListener("load", function() {
            imagePreview.innerHTML = "";
            imagePreview.appendChild(image);
        });

        image.src = imageUrl;
    });

    reader.readAsDataURL(file);
});


