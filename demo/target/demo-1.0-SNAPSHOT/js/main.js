function validateX(value) {
    if (isNaN(value)) {
        throw new Error("Неверное значение X");
    }
    if(Number(value) < 4 || Number(value) > 4){
        throw new Error("Число X не входит в диапазон");
    }
    return true;
}

function validateY(value) {
    if (isNaN(value)) {
        throw new Error("Неверное значение Y");
    }
    const decimalPart = String(value).trim().split('.')[1];
    if (decimalPart && decimalPart.length > 15) {
        throw new Error("Слишком много знаков после запятой");
    }
    const y = Number(value);
    if (y < -5 || y > 5) {
        throw new Error("Число Y не входит в диапазон");
    }
    return true;
}

function validateR(value) {
    if (!value) {
        throw new Error("Пожалуйста, выберите значение R");
    }
    return true;
}

function validateFormInput(ev) {
    try {
        const x = validateX(ev.target.x);
        const y = validateY(ev.target.y);
        const r = validateR(ev.target.r);
        return x && y && r;
    } catch (e) {
        console.log(e)
    }
    return false;
}

// Обработчик кликов по SVG
function handleClick(event) {
    const svg = document.getElementById("plate");
    const point = svg.createSVGPoint();
    point.x = event.clientX;
    point.y = event.clientY;
    const coords = point.matrixTransform(svg.getScreenCTM().inverse());

    const r = parseFloat(document.querySelector('input[name$=":r"]:checked')?.value);

    if (!r) {
        alert("Пожалуйста, выберите значение R");
        return;
    }

    let x =  +((coords.x - 250) / 50).toFixed(2);
    let y = +((250 - coords.y) / 50).toFixed(2);

    display(event);

    document.querySelector('input[name$=":x"]').value = x;
    document.querySelector('input[name$=":y"]').value = y;
    document.querySelector('input[name="data-form:r"][value="' + r + '"]').checked = true;

    document.getElementById("data-form:submit").click();
}

function display(e) {
    const svg = document.getElementById("plate");
    const rect = svg.getBoundingClientRect();
    const x = Math.round(e.clientX - rect.left);
    const y = Math.round(e.clientY - rect.top);
    addPoint(x, y);
}

function addPoint(x, y) {
    const svg = document.getElementById("plate");
    const point = document.createElementNS("http://www.w3.org/2000/svg", "circle");
    point.setAttribute('id', `c-${Math.round(Math.random() * 10000)}`);
    point.setAttribute('cx', `${x}`);
    point.setAttribute('cy', `${y}`);
    point.setAttribute('r', '4');
    point.setAttribute('fill', 'grey');
    svg.appendChild(point);
}

function drawPoints() {
    const svg = document.getElementById("plate");
    svg.querySelectorAll(".data-point").forEach(point => point.remove());

    const points = document.querySelectorAll("#data .point");

    points.forEach(point => {
        const x = parseFloat(point.getAttribute("data-x"));
        const y = parseFloat(point.getAttribute("data-y"));
        const r = parseFloat(point.getAttribute("data-r"));
        const result = point.getAttribute("data-result") === "true";

        const scaleFactor = 100 / r;
        const svgX = 250 + x * scaleFactor;
        const svgY = 250 - y * scaleFactor;

        const circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");
        circle.setAttribute("cx", `${svgX}`);
        circle.setAttribute("cy", `${svgY}`);
        circle.setAttribute("r", "4");
        circle.setAttribute("fill", result ? "green" : "red");
        circle.classList.add("data-point");

        svg.appendChild(circle);
    });
}

document.addEventListener("DOMContentLoaded", function () {
    document.getElementById("data-form").addEventListener("submit", (ev) => validateFormInput(ev));
    document.getElementById("plate").addEventListener("click", handleClick);
    document.querySelector("[name='data-form:r']:nth-child(1)").checked = true;
    drawPoints();
});
