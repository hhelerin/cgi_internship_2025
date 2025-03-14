function searchFlights() {
    const from = document.getElementById("from").value;
    const to = document.getElementById("to").value;
    const date = document.getElementById("date").value;
    const passengers = document.getElementById("passengers").value;

    fetch(`/api/flights/search?from=${from}&to=${to}&date=${date}&passengers=${passengers}`)
        .then(response => response.json())
        .then(data => displayFlights(data))
        .catch(error => console.error("Error fetching flights:", error));
}

function displayFlights(flights) {
    const flightResults = document.getElementById("flight-results");
    flightResults.innerHTML = ""; // Clear previous results

    flights.forEach(flight => {
        const flightDiv = document.createElement("div");
        flightDiv.className = "flight";

        flightDiv.innerHTML = `
            <p>Flight Number: ${flight.flightNumber}</p>
            <p>From: ${flight.origin}</p>
            <p>To: ${flight.destination}</p>
            <p>Date: ${flight.date}</p>
            <p>Price: $${flight.price}</p>
            <p>Available Seats: ${flight.availableSeats}</p>
            <button>Choose</button>
        `;

        flightResults.appendChild(flightDiv);
    });
}
