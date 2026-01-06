/**
 * 
 */
document.getElementById("searchBar").addEventListener("keyup", function () {
			let filter = this.value.toLowerCase();
			let rows = document.querySelectorAll("#bookTable .Data_Rows");

			rows.forEach(row => {
				let text = row.innerText.toLowerCase();
				row.style.display = text.includes(filter) ? "" : "none";
			});
		});