var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "480",
        "ok": "480",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "4100",
        "ok": "4100",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1286",
        "ok": "1286",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "796",
        "ok": "796",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1236",
        "ok": "1236",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1827",
        "ok": "1827",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2626",
        "ok": "2626",
        "ko": "-"
    },
    "percentiles4": {
        "total": "3447",
        "ok": "3447",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 130,
    "percentage": 27
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 94,
    "percentage": 20
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 256,
    "percentage": 53
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "4.174",
        "ok": "4.174",
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
        "total": "240",
        "ok": "240",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "12",
        "ok": "12",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "2945",
        "ok": "2945",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "787",
        "ok": "787",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "625",
        "ok": "625",
        "ko": "-"
    },
    "percentiles1": {
        "total": "688",
        "ok": "688",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1189",
        "ok": "1189",
        "ko": "-"
    },
    "percentiles3": {
        "total": "1876",
        "ok": "1876",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2830",
        "ok": "2830",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 130,
    "percentage": 54
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 51,
    "percentage": 21
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 59,
    "percentage": 25
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2.087",
        "ok": "2.087",
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
        "total": "240",
        "ok": "240",
        "ko": "0"
    },
    "minResponseTime": {
        "total": "1016",
        "ok": "1016",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "4100",
        "ok": "4100",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1785",
        "ok": "1785",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "616",
        "ok": "616",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1687",
        "ok": "1687",
        "ko": "-"
    },
    "percentiles2": {
        "total": "2132",
        "ok": "2132",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2786",
        "ok": "2786",
        "ko": "-"
    },
    "percentiles4": {
        "total": "3860",
        "ok": "3860",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 43,
    "percentage": 18
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 197,
    "percentage": 82
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2.087",
        "ok": "2.087",
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
