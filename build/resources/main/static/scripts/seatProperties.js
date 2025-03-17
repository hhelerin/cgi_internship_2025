function showSeatProperties(rowNumber, columnChar, seatClass, reclineType, window, aisle, emergencyExit, tv, powerPort, babyBassinet, available) {
    const url = `/flightland/seatProperties?rowNumber=${rowNumber}&columnChar=${columnChar}&seatClass=${seatClass}&reclineType=${reclineType}` +
        `&window=${window}&aisle=${aisle}&emergencyExit=${emergencyExit}&tv=${tv}&powerPort=${powerPort}` +
        `&babyBassinet=${babyBassinet}&available=${available}`;

    fetch(url)
        .then(response => response.text())
        .then(data => {
            const infoBox = document.getElementById('seatInfo');
            infoBox.innerText = data;
        });
}
