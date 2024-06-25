window.addEventListener('load', function () {
// Abrir la modal al cargar la página
modal.classList.add('modal--show');
});

const openModal = document.querySelector('.hero__cta');
const modal = document.querySelector('.modal');
const closeModal = document.querySelector('#modal__close');

openModal.addEventListener('click', (e) => {
e.preventDefault();
modal.classList.add('modal--show');
});

closeModal.addEventListener('click', (e) => {
e.preventDefault();
modal.classList.remove('modal--show');
});
