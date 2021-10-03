
function getAllRequests(){
    let url = 'http://localhost:7000/ReimbursementRequest/all'
    let xhr = new XMLHttpRequest();


    console.log("Got here2 ");

    xhr.onreadystatechange = function(){

        if(xhr.readyState === 4 && xhr.status === 200 ){
            let requests = JSON.parse(xhr.response);

            console.log(requests);
            console.log("Got here");

            for (let request of requests){
               
                    //let request_container = document.getElementById('New entry');
                
                    let new_row = document.createElement('tr');

                    let requestID_column = document.createElement('th');
                    requestID_column.innerText = request.requestID;
                
                    let status_column = document.createElement('th');
                    status_column.innerText = request.status;
                
                    let reason_column = document.createElement('th');
                    reason_column.innerText = request.reason
                
                    let amount_column = document.createElement('th');
                    amount_column.innerText = request.amount;
                

                    new_row.appendChild(requestID_column);
                    new_row.appendChild(amount_column);
                    new_row.appendChild(reason_column);
                    new_row.appendChild(status_column);
                    
                
                    let RequestTable = document.getElementById('RequestTable');
                    RequestTable.appendChild(new_row);
                
                
            }


        }


    }


    window.onload = function(){
        this.getAllRequests();
    }
}
