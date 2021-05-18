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
        "total": "19",
        "ok": "19",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2144",
        "ok": "2144",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "668",
        "ok": "668",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "641",
        "ok": "641",
        "ko": "-"
    },
    "percentiles1": {
        "total": "634",
        "ok": "634",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1172",
        "ok": "1172",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1452",
        "ok": "1452",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2128",
        "ok": "2128",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 28,
    "percentage": 50
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 16,
    "percentage": 29
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 12,
    "percentage": 21
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
        "total": "19",
        "ok": "19",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "190",
        "ok": "190",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "55",
        "ok": "55",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "48",
        "ok": "48",
        "ko": "-"
    },
    "percentiles1": {
        "total": "33",
        "ok": "33",
        "ko": "-"
    },
    "percentiles2": {
        "total": "64",
        "ok": "64",
        "ko": "-"
    },
    "percentiles3": {
        "total": "158",
        "ok": "158",
        "ko": "-"
    },
    "percentiles4": {
        "total": "183",
        "ok": "183",
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
        "total": "1077",
        "ok": "1077",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2144",
        "ok": "2144",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1281",
        "ok": "1281",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "261",
        "ok": "261",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1175",
        "ok": "1175",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1325",
        "ok": "1325",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1911",
        "ok": "1911",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2136",
        "ok": "2136",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 16,
    "percentage": 57
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 12,
    "percentage": 43
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
