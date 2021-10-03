function addNewRequest(){
    let request_container = document.getElementById('New entry');

    let new_row = document.createElement('tr');


    let status_column = document.createElement('th');
    status_column.innerText = "Approved";

    let reason_column = document.createElement('th');
    reason_column.innerText = "A different Kind of reason."

    let amount_column = document.createElement('th');
    amount_column.innerText = 50;

    let employeeID_column = document.createElement('th');
    employeeID_column.innerText = 2;

    new_row.appendChild(status_column);
    new_row.appendChild(reason_column);
    new_row.appendChild(amount_column);
    new_row.appendChild(employeeID_column);

    let RequestTable = document.getElementById('RequestTable');
    RequestTable.appendChild(new_row);

}