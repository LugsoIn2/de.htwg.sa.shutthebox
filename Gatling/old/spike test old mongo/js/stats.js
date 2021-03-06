var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "480",
        "ok": "479",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "15",
        "ok": "15",
        "ko": "314"
    },
    "maxResponseTime": {
        "total": "4550",
        "ok": "4550",
        "ko": "314"
    },
    "meanResponseTime": {
        "total": "1292",
        "ok": "1294",
        "ko": "314"
    },
    "standardDeviation": {
        "total": "876",
        "ok": "876",
        "ko": "0"
    },
    "percentiles1": {
        "total": "1220",
        "ok": "1219",
        "ko": "314"
    },
    "percentiles2": {
        "total": "1789",
        "ok": "1789",
        "ko": "314"
    },
    "percentiles3": {
        "total": "3158",
        "ok": "3158",
        "ko": "314"
    },
    "percentiles4": {
        "total": "3859",
        "ok": "3862",
        "ko": "314"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 145,
    "percentage": 30
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 89,
    "percentage": 19
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 245,
    "percentage": 51
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "4.174",
        "ok": "4.165",
        "ko": "0.009"
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
        "total": "15",
        "ok": "15",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "3401",
        "ok": "3401",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "785",
        "ok": "785",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "675",
        "ok": "675",
        "ko": "-"
    },
    "percentiles1": {
        "total": "622",
        "ok": "622",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1118",
        "ok": "1118",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2078",
        "ok": "2078",
        "ko": "-"
    },
    "percentiles4": {
        "total": "2541",
        "ok": "2541",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 145,
    "percentage": 60
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 39,
    "percentage": 16
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 56,
    "percentage": 23
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
        "ok": "239",
        "ko": "1"
    },
    "minResponseTime": {
        "total": "314",
        "ok": "1020",
        "ko": "314"
    },
    "maxResponseTime": {
        "total": "4550",
        "ok": "4550",
        "ko": "314"
    },
    "meanResponseTime": {
        "total": "1800",
        "ok": "1806",
        "ko": "314"
    },
    "standardDeviation": {
        "total": "751",
        "ok": "747",
        "ko": "0"
    },
    "percentiles1": {
        "total": "1597",
        "ok": "1597",
        "ko": "314"
    },
    "percentiles2": {
        "total": "2066",
        "ok": "2071",
        "ko": "314"
    },
    "percentiles3": {
        "total": "3408",
        "ok": "3410",
        "ko": "314"
    },
    "percentiles4": {
        "total": "4268",
        "ok": "4270",
        "ko": "314"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 50,
    "percentage": 21
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 189,
    "percentage": 79
},
    "group4": {
    "name": "failed",
    "count": 1,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "2.087",
        "ok": "2.078",
        "ko": "0.009"
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
