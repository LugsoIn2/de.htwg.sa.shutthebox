var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "56",
        "ok": "56",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "24",
        "ok": "24",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1975",
        "ok": "1975",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "655",
        "ok": "655",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "585",
        "ok": "585",
        "ko": "-"
    },
    "percentiles1": {
        "total": "866",
        "ok": "866",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1088",
        "ok": "1088",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1666",
        "ok": "1666",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1922",
        "ok": "1922",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 28,
    "percentage": 50
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 24,
    "percentage": 43
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 4,
    "percentage": 7
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2.8",
        "ok": "2.8",
        "ko": "-"
    }
},
contents: {
"req_request-0-684d2": {
        type: "REQUEST",
        name: "request_0",
path: "request_0",
pathFormatted: "req_request-0-684d2",
stats: {
    "name": "request_0",
    "numberOfRequests": {
        "total": "28",
        "ok": "28",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "24",
        "ok": "24",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "709",
        "ok": "709",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "121",
        "ok": "121",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "201",
        "ok": "201",
        "ko": "-"
    },
    "percentiles1": {
        "total": "40",
        "ok": "40",
        "ko": "-"
    },
    "percentiles2": {
        "total": "74",
        "ok": "74",
        "ko": "-"
    },
    "percentiles3": {
        "total": "691",
        "ok": "691",
        "ko": "-"
    },
    "percentiles4": {
        "total": "707",
        "ok": "707",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 28,
    "percentage": 100
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 0,
    "percentage": 0
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
        "total": "1.4",
        "ok": "1.4",
        "ko": "-"
    }
}
    },"req_request-1-46da4": {
        type: "REQUEST",
        name: "request_1",
path: "request_1",
pathFormatted: "req_request-1-46da4",
stats: {
    "name": "request_1",
    "numberOfRequests": {
        "total": "28",
        "ok": "28",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1022",
        "ok": "1022",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "1975",
        "ok": "1975",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1190",
        "ok": "1190",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "270",
        "ok": "270",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1088",
        "ok": "1088",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1128",
        "ok": "1128",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1878",
        "ok": "1878",
        "ko": "-"
    },
    "percentiles4": {
        "total": "1949",
        "ok": "1949",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 24,
    "percentage": 86
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 4,
    "percentage": 14
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.4",
        "ok": "1.4",
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
