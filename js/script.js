 const filterForm = document.getElementById('filter-form');
const filterButton = document.getElementById('filter-button');
const dogImagesDiv = document.getElementById('dog-images');
const saveListButton = document.getElementById('save-list-button');

filterButton.addEventListener('click', (e) => {
    e.preventDefault();
    const responseCode = document.getElementById('response-code').value;
    const imageUrl = `https://http.dog/${responseCode}.jpg`;
    const img = document.createElement('img');
    img.src = imageUrl;
    dogImagesDiv.appendChild(img);
});

saveListButton.addEventListener('click', () => {
    const images = dogImagesDiv.children;
    const list = [];
    for (let i = 0; i < images.length; i++) {
        list.push(images[i].src);
    }
    // Save list to database
    fetch('/lists', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(list)
    })
    .then(response => response.json())
    .then(data => console.log(data))
    .catch(error => console.error('Error saving list:', error));
});
