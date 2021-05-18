var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2000",
        "ok": "895",
        "ko": "1105"
    },
    "minResponseTime": {
        "total": "802",
        "ok": "802",
        "ko": "7770"
    },
    "maxResponseTime": {
        "total": "60015",
        "ok": "58862",
        "ko": "60015"
    },
    "meanResponseTime": {
        "total": "27397",
        "ok": "16615",
        "ko": "36130"
    },
    "standardDeviation": {
        "total": "15807",
        "ok": "13326",
        "ko": "11749"
    },
    "percentiles1": {
        "total": "32535",
        "ok": "17490",
        "ko": "33187"
    },
    "percentiles2": {
        "total": "33292",
        "ok": "26306",
        "ko": "33856"
    },
    "percentiles3": {
        "total": "60007",
        "ok": "39136",
        "ko": "60010"
    },
    "percentiles4": {
        "total": "60013",
        "ok": "46034",
        "ko": "60013"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 75,
    "percentage": 4
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 820,
    "percentage": 41
},
    "group4": {
    "name": "failed",
    "count": 1105,
    "percentage": 55
},
    "meanNumberOfRequestsPerSecond": {
        "total": "21.277",
        "ok": "9.521",
        "ko": "11.755"
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
        "ok": "274",
        "ko": "726"
    },
    "minResponseTime": {
        "total": "802",
        "ok": "802",
        "ko": "7770"
    },
    "maxResponseTime": {
        "total": "60015",
        "ok": "58862",
        "ko": "60015"
    },
    "meanResponseTime": {
        "total": "33467",
        "ok": "22033",
        "ko": "37782"
    },
    "standardDeviation": {
        "total": "14942",
        "ok": "13911",
        "ko": "12905"
    },
    "percentiles1": {
        "total": "33255",
        "ok": "20255",
        "ko": "33692"
    },
    "percentiles2": {
        "total": "34028",
        "ok": "31515",
        "ko": "34051"
    },
    "percentiles3": {
        "total": "60010",
        "ok": "45165",
        "ko": "60011"
    },
    "percentiles4": {
        "total": "60014",
        "ok": "50201",
        "ko": "60014"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 9,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 265,
    "percentage": 27
},
    "group4": {
    "name": "failed",
    "count": 726,
    "percentage": 73
},
    "meanNumberOfRequestsPerSecond": {
        "total": "10.638",
        "ok": "2.915",
        "ko": "7.723"
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
        "ok": "621",
        "ko": "379"
    },
    "minResponseTime": {
        "total": "1069",
        "ok": "1069",
        "ko": "14594"
    },
    "maxResponseTime": {
        "total": "60013",
        "ok": "38218",
        "ko": "60013"
    },
    "meanResponseTime": {
        "total": "21327",
        "ok": "14225",
        "ko": "32965"
    },
    "standardDeviation": {
        "total": "14241",
        "ok": "12323",
        "ko": "8257"
    },
    "percentiles1": {
        "total": "24072",
        "ok": "16283",
        "ko": "32558"
    },
    "percentiles2": {
        "total": "32556",
        "ok": "24134",
        "ko": "32589"
    },
    "percentiles3": {
        "total": "34615",
        "ok": "34456",
        "ko": "60007"
    },
    "percentiles4": {
        "total": "60008",
        "ok": "37145",
        "ko": "60008"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 66,
    "percentage": 7
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 555,
    "percentage": 56
},
    "group4": {
    "name": "failed",
    "count": 379,
    "percentage": 38
},
    "meanNumberOfRequestsPerSecond": {
        "total": "10.638",
        "ok": "6.606",
        "ko": "4.032"
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
