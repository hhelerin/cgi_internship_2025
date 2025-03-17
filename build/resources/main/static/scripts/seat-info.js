function showSeatInfo(event) {
    const seatElement = event.currentTarget;
    const properties = seatElement.getAttribute("data-properties");

    if (!properties) return;

    const seatInfo = document.getElementById("seatInfo");
    seatInfo.innerHTML = properties.replace(/, /g, "<br>");
    seatInfo.style.display = "block";
    seatInfo.style.top = `${event.clientY + 10}px`;
    seatInfo.style.left = `${event.clientX + 10}px`;
}

function hideSeatInfo() {
    const seatInfo = document.getElementById("seatInfo");
    seatInfo.style.display = "none";
}
