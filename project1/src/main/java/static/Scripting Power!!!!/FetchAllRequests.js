
function fetchAll(){

    let url = 'http://localhost:7000/ReimbursementRequest/all'

    fetch(url).then(
        response => {
            response.json().then(
                json_body => {

                    console.log(json_body);

                    for (let request of json_body){
               
                        //let request_container = document.getElementById('New entry');
                    
                        let new_row = document.createElement('tr');
                    
                    
                        let status_column = document.createElement('th');
                        if (request.status === 2){
                            status_column.innerText = "Pending"
                        } else if (request.status === 1) {
                            status_column.innerText = "Approved"
                        } else {
                            status_column.innerText = "Denied"
                        }
                    
                        let reason_column = document.createElement('th');
                        reason_column.innerText = request.reason
                    
                        let amount_column = document.createElement('th');
                        amount_column.innerText = request.amount;
                    
                        let employeeID_column = document.createElement('th');
                        employeeID_column.innerText = request.requestID;
                    
                        new_row.appendChild(status_column);
                        new_row.appendChild(reason_column);
                        new_row.appendChild(amount_column);
                        new_row.appendChild(employeeID_column);
                    
                        let RequestTable = document.getElementById('RequestTable');
                        RequestTable.appendChild(new_row);
                    
                    };
                }
            )
        }
    )
    
    
}

window.onload = function(){
    this.fetchAll();
}
