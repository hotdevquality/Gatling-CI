var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2",
        "ok": "2",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "7356",
        "ok": "7356",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "9472",
        "ok": "9472",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "8414",
        "ok": "8414",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1058",
        "ok": "1058",
        "ko": "-"
    },
    "percentiles1": {
        "total": "8414",
        "ok": "8414",
        "ko": "-"
    },
    "percentiles2": {
        "total": "8943",
        "ok": "8943",
        "ko": "-"
    },
    "percentiles3": {
        "total": "9366",
        "ok": "9366",
        "ko": "-"
    },
    "percentiles4": {
        "total": "9451",
        "ok": "9451",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 2,
        "percentage": 100
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "0.2",
        "ok": "0.2",
        "ko": "-"
    }
},
contents: {
"req_bussearch-381d3": {
        type: "REQUEST",
        name: "BusSearch",
path: "BusSearch",
pathFormatted: "req_bussearch-381d3",
stats: {
    "name": "BusSearch",
    "numberOfRequests": {
        "total": "2",
        "ok": "2",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "7356",
        "ok": "7356",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "9472",
        "ok": "9472",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "8414",
        "ok": "8414",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "1058",
        "ok": "1058",
        "ko": "-"
    },
    "percentiles1": {
        "total": "8414",
        "ok": "8414",
        "ko": "-"
    },
    "percentiles2": {
        "total": "8943",
        "ok": "8943",
        "ko": "-"
    },
    "percentiles3": {
        "total": "9366",
        "ok": "9366",
        "ko": "-"
    },
    "percentiles4": {
        "total": "9451",
        "ok": "9451",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 0,
        "percentage": 0
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 2,
        "percentage": 100
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "0.2",
        "ok": "0.2",
        "ko": "-"
    }
}
    }
}

}

function fillStats(stat){
    $("#numberOfRequests").append(stat.numberOfRequests.total);
    $("#numberOfRequestsOK").append(stat.numberOfRequests.ok);
    $("#numberOfRequestsKO").append(stat.numberOfRequests.ko);

    $("#minResponseTime").append(stat.minResponseTime.total);
    $("#minResponseTimeOK").append(stat.minResponseTime.ok);
    $("#minResponseTimeKO").append(stat.minResponseTime.ko);

    $("#maxResponseTime").append(stat.maxResponseTime.total);
    $("#maxResponseTimeOK").append(stat.maxResponseTime.ok);
    $("#maxResponseTimeKO").append(stat.maxResponseTime.ko);

    $("#meanResponseTime").append(stat.meanResponseTime.total);
    $("#meanResponseTimeOK").append(stat.meanResponseTime.ok);
    $("#meanResponseTimeKO").append(stat.meanResponseTime.ko);

    $("#standardDeviation").append(stat.standardDeviation.total);
    $("#standardDeviationOK").append(stat.standardDeviation.ok);
    $("#standardDeviationKO").append(stat.standardDeviation.ko);

    $("#percentiles1").append(stat.percentiles1.total);
    $("#percentiles1OK").append(stat.percentiles1.ok);
    $("#percentiles1KO").append(stat.percentiles1.ko);

    $("#percentiles2").append(stat.percentiles2.total);
    $("#percentiles2OK").append(stat.percentiles2.ok);
    $("#percentiles2KO").append(stat.percentiles2.ko);

    $("#percentiles3").append(stat.percentiles3.total);
    $("#percentiles3OK").append(stat.percentiles3.ok);
    $("#percentiles3KO").append(stat.percentiles3.ko);

    $("#percentiles4").append(stat.percentiles4.total);
    $("#percentiles4OK").append(stat.percentiles4.ok);
    $("#percentiles4KO").append(stat.percentiles4.ko);

    $("#meanNumberOfRequestsPerSecond").append(stat.meanNumberOfRequestsPerSecond.total);
    $("#meanNumberOfRequestsPerSecondOK").append(stat.meanNumberOfRequestsPerSecond.ok);
    $("#meanNumberOfRequestsPerSecondKO").append(stat.meanNumberOfRequestsPerSecond.ko);
}
