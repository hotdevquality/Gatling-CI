var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "5",
        "ok": "5",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "561",
        "ok": "561",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "873",
        "ok": "873",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "642",
        "ok": "642",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "116",
        "ok": "116",
        "ko": "-"
    },
    "percentiles1": {
        "total": "585",
        "ok": "585",
        "ko": "-"
    },
    "percentiles2": {
        "total": "610",
        "ok": "610",
        "ko": "-"
    },
    "percentiles3": {
        "total": "820",
        "ok": "820",
        "ko": "-"
    },
    "percentiles4": {
        "total": "862",
        "ok": "862",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 4,
        "percentage": 80
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 1,
        "percentage": 20
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "1",
        "ok": "1",
        "ko": "-"
    }
},
contents: {
"req_basic-open-mode-7480b": {
        type: "REQUEST",
        name: "Basic Open Model",
path: "Basic Open Model",
pathFormatted: "req_basic-open-mode-7480b",
stats: {
    "name": "Basic Open Model",
    "numberOfRequests": {
        "total": "5",
        "ok": "5",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "561",
        "ok": "561",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "873",
        "ok": "873",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "642",
        "ok": "642",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "116",
        "ok": "116",
        "ko": "-"
    },
    "percentiles1": {
        "total": "585",
        "ok": "585",
        "ko": "-"
    },
    "percentiles2": {
        "total": "610",
        "ok": "610",
        "ko": "-"
    },
    "percentiles3": {
        "total": "820",
        "ok": "820",
        "ko": "-"
    },
    "percentiles4": {
        "total": "862",
        "ok": "862",
        "ko": "-"
    },
    "group1": {
        "name": "t < 800 ms",
        "count": 4,
        "percentage": 80
    },
    "group2": {
        "name": "800 ms < t < 1200 ms",
        "count": 1,
        "percentage": 20
    },
    "group3": {
        "name": "t > 1200 ms",
        "count": 0,
        "percentage": 0
    },
    "group4": {
        "name": "failed",
        "count": 0,
        "percentage": 0
    },
    "meanNumberOfRequestsPerSecond": {
        "total": "1",
        "ok": "1",
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
