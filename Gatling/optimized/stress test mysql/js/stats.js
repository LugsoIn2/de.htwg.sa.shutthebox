var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2000",
        "ok": "495",
        "ko": "1505"
    },
    "minResponseTime": {
        "total": "917",
        "ok": "917",
        "ko": "15667"
    },
    "maxResponseTime": {
        "total": "60016",
        "ok": "59933",
        "ko": "60016"
    },
    "meanResponseTime": {
        "total": "32343",
        "ok": "23966",
        "ko": "35098"
    },
    "standardDeviation": {
        "total": "14249",
        "ok": "20713",
        "ko": "9901"
    },
    "percentiles1": {
        "total": "33102",
        "ok": "20409",
        "ko": "33125"
    },
    "percentiles2": {
        "total": "33610",
        "ok": "44416",
        "ko": "33520"
    },
    "percentiles3": {
        "total": "60007",
        "ok": "55411",
        "ko": "60008"
    },
    "percentiles4": {
        "total": "60013",
        "ok": "59487",
        "ko": "60015"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 9,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 486,
    "percentage": 24
},
    "group4": {
    "name": "failed",
    "count": 1505,
    "percentage": 75
},
    "meanNumberOfRequestsPerSecond": {
        "total": "16.807",
        "ok": "4.16",
        "ko": "12.647"
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
        "total": "1000",
        "ok": "172",
        "ko": "828"
    },
    "minResponseTime": {
        "total": "917",
        "ok": "917",
        "ko": "15667"
    },
    "maxResponseTime": {
        "total": "60015",
        "ok": "59771",
        "ko": "60015"
    },
    "meanResponseTime": {
        "total": "34299",
        "ok": "26942",
        "ko": "35827"
    },
    "standardDeviation": {
        "total": "12326",
        "ok": "18020",
        "ko": "10122"
    },
    "percentiles1": {
        "total": "33380",
        "ok": "24914",
        "ko": "33401"
    },
    "percentiles2": {
        "total": "33788",
        "ok": "43314",
        "ko": "33668"
    },
    "percentiles3": {
        "total": "60008",
        "ok": "56030",
        "ko": "60009"
    },
    "percentiles4": {
        "total": "60012",
        "ok": "59116",
        "ko": "60013"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 8,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 164,
    "percentage": 16
},
    "group4": {
    "name": "failed",
    "count": 828,
    "percentage": 83
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.403",
        "ok": "1.445",
        "ko": "6.958"
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
        "total": "1000",
        "ok": "323",
        "ko": "677"
    },
    "minResponseTime": {
        "total": "1192",
        "ok": "1192",
        "ko": "16371"
    },
    "maxResponseTime": {
        "total": "60016",
        "ok": "59933",
        "ko": "60016"
    },
    "meanResponseTime": {
        "total": "30387",
        "ok": "22381",
        "ko": "34207"
    },
    "standardDeviation": {
        "total": "15700",
        "ok": "21849",
        "ko": "9549"
    },
    "percentiles1": {
        "total": "32520",
        "ok": "4019",
        "ko": "32527"
    },
    "percentiles2": {
        "total": "33136",
        "ok": "44716",
        "ko": "33103"
    },
    "percentiles3": {
        "total": "60007",
        "ok": "55226",
        "ko": "60008"
    },
    "percentiles4": {
        "total": "60015",
        "ok": "59305",
        "ko": "60015"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 1,
    "percentage": 0
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 322,
    "percentage": 32
},
    "group4": {
    "name": "failed",
    "count": 677,
    "percentage": 68
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.403",
        "ok": "2.714",
        "ko": "5.689"
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
