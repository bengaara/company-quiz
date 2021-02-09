$(document).ready(function() {   

	 var title = {
             text: 'Onboarding​ ​Flow'   
          };
          var subtitle = {
             text: 'Retention​ ​curve​ ​chart: Weekly cohorts​'
          };
          var xAxis = {
        		  title: {
                      text: 'Steps'
                   },
             categories: ['Create Account(0)', 'Activate (20%)', 'Profile Information (40%)', 'Job interests (50%)', 'Experience (70%)', 'Freelancer (90%)','Waiting Approval (99%)', 'Approval (100%)']
          };
          var yAxis = {
             title: {
                text: 'Percentage Users (%)'
             }
          };
         var legend = {
              layout: 'vertical',
              align: 'right',
              verticalAlign: 'middle'
          };
          var plotOptions = {
             line: {
                dataLabels: {
                   enabled: true
                },   
                enableMouseTracking: false
             }
          };
          var series = [//{name: 'Tokyo', data: [7.0, 6.9, 9.5, 14.5, 18.4, 21.5, 25.2, 26.5]}, 
                        //{ name: 'London',data: [3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6]}
          ];
 
          var json = {};
          json.title = title;
          json.subtitle = subtitle;
          json.xAxis = xAxis;
          json.yAxis = yAxis;  
          json.legend = legend;
          json.series = series;
          json.plotOptions = plotOptions;
          $('#container').highcharts(json); 

          $('#linkReload').click(function(){ requestData(); return false; });  
          
          requestData();
          
          
});
function requestData() {
    $.ajax({
        url: '/cohorts',
        type: "GET",
        dataType: "json",
        data : {},
        success: function(data) {
        	
    //     $('#container').highcharts().addSeries({
   //     	 name: "mentions",data:
    //    	 data.month_mentions_graphic
    //    });
        	
        	var chart = $('#container').highcharts();
        	
        	while( chart.series.length > 0 ) {
        	    chart.series[0].remove( false );
        	}
        	chart.redraw();
        	data.forEach(function(d) {
        	    console.log(d);
        	    chart.addSeries({ name: d.name,data:d.data });
        	});
        },
        cache: false
    });
}
