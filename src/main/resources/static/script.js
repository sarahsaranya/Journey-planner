document.getElementById("listStationsButton").addEventListener("click", async () => {
    const response = await fetch('http://localhost:8081/api/listStations');
    const data = await response.json();
    document.getElementById("output").textContent = JSON.stringify(data, null, 2);
});

document.getElementById("showMapButton").addEventListener("click", async () => {
    const response = await fetch('http://localhost:8081/api/showMetroMap');
    const data = await response.json();
    document.getElementById("output").textContent = JSON.stringify(data, null, 2);
});

document.getElementById("shortestDistanceButton").addEventListener("click", async () => {
    const start = document.getElementById("startStation").value;
    const end = document.getElementById("endStation").value;

    const response = await fetch(`http://localhost:8081/api/shortestDistance?start=${start}&end=${end}`);
    const data = await response.json();
    document.getElementById("output").textContent = JSON.stringify(data, null, 2);
});

document.getElementById("shortestTimeButton").addEventListener("click", async () => {
    const start = document.getElementById("startStation").value;
    const end = document.getElementById("endStation").value;

    const response = await fetch(`http://localhost:8081/api/shortestTime?start=${start}&end=${end}`);
    const data = await response.json();
    document.getElementById("output").textContent = JSON.stringify(data, null, 2);
});

document.getElementById("shortestPathDistanceButton").addEventListener("click", async () => {
    const start = document.getElementById("startStation").value;
    const end = document.getElementById("endStation").value;

    const response = await fetch(`http://localhost:8081/api/shortestPathDistance?start=${start}&end=${end}`);
    const data = await response.json();
    document.getElementById("output").textContent = JSON.stringify(data, null, 2);
});

document.getElementById("shortestPathTimeButton").addEventListener("click", async () => {
    const start = document.getElementById("startStation").value;
    const end = document.getElementById("endStation").value;

    const response = await fetch(`http://localhost:8081/api/shortestPathTime?start=${start}&end=${end}`);
    const data = await response.json();
    document.getElementById("output").textContent = JSON.stringify(data, null, 2);
});
