


function FetchAverage(){

    let url = 'http://localhost:7000/ReimbursementRequest/average'

    fetch(url).then(
        response => {
            response.json().then(
                json_body => {

                    let statsrow = document.getElementById('stats_row');
                    let titlerow = document.getElementById('stats_title_row');


                    let Amount_Average_Data = document.createElement('th');
                    let title_text = document.createElement('td');


                    Amount_Average_Data.innerText= json_body;
                    title_text.innerText = "Average Amount Requested";
                    statsrow.append(Amount_Average_Data);
                    titlerow.append(title_text);
                }
            )
        }
    )


    url = 'http://localhost:7000/ReimbursementRequest/max'

    fetch(url).then(
        response => {
            response.json().then(
                json_body => {

                    let statsrow = document.getElementById('stats_row');
                    let titlerow = document.getElementById('stats_title_row');
                    
                    let Amount_Max_Data = document.createElement('th');
                    let title_text = document.createElement('td');
                    Amount_Max_Data.innerText= json_body;
                    title_text.innerText = "Highest Amount Requested";
                    statsrow.append(Amount_Max_Data);
                    titlerow.append(title_text);
                    
                }
            )
        }
    )


    url = 'http://localhost:7000/ReimbursementRequest/min'

    fetch(url).then(
        response => {
            response.json().then(
                json_body => {

                    let statsrow = document.getElementById('stats_row');
                    let titlerow = document.getElementById('stats_title_row');

                    let Amount_Min_Data = document.createElement('th');
                    let title_text = document.createElement('td');
                    Amount_Min_Data.innerText= json_body;
                    title_text.innerText = "Lowest Amount Requested";
                    statsrow.append(Amount_Min_Data);
                    titlerow.append(title_text);
                }
            )
        }
    )

    url = 'http://localhost:7000/ReimbursementRequest/sum'

    fetch(url).then(
        response => {
            response.json().then(
                json_body => {

                    let statsrow = document.getElementById('stats_row');
                    let titlerow = document.getElementById('stats_title_row');

                    let Amount_Sum_Data = document.createElement('th');
                    let title_text = document.createElement('td');
                    Amount_Sum_Data.innerText= json_body;
                    title_text.innerText = "Total Amount Requested including Denied";
                    statsrow.append(Amount_Sum_Data);
                    titlerow.append(title_text);
                }
            )
        }
    )



    url = 'http://localhost:7000/ReimbursementRequest/count'

    fetch(url).then(
        response => {
            response.json().then(
                json_body => {

                    let statsrow = document.getElementById('stats_row');
                    let titlerow = document.getElementById('stats_title_row');
                    
                    let Amount_Count_Data = document.createElement('th');
                    let title_text = document.createElement('td');
                    Amount_Count_Data.innerText= json_body;

                    title_text.innerText = "Total Number Of Requests Made";
                    statsrow.append(Amount_Count_Data);
                    titlerow.append(title_text);
                }
            )
        }
    )
}


window.onload = function(){
    this.FetchAverage();
    
}