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
        "total": "17",
        "ok": "17",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "4246",
        "ok": "4246",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1796",
        "ok": "1796",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "974",
        "ok": "974",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1766",
        "ok": "1766",
        "ko": "-"
    },
    "percentiles2": {
        "total": "2517",
        "ok": "2517",
        "ko": "-"
    },
    "percentiles3": {
        "total": "3477",
        "ok": "3477",
        "ko": "-"
    },
    "percentiles4": {
        "total": "3880",
        "ok": "3880",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 88,
    "percentage": 18
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 46,
    "percentage": 10
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 346,
    "percentage": 72
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "3.75",
        "ok": "3.75",
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
        "total": "17",
        "ok": "17",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "3850",
        "ok": "3850",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "1213",
        "ok": "1213",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "807",
        "ok": "807",
        "ko": "-"
    },
    "percentiles1": {
        "total": "1186",
        "ok": "1186",
        "ko": "-"
    },
    "percentiles2": {
        "total": "1770",
        "ok": "1770",
        "ko": "-"
    },
    "percentiles3": {
        "total": "2590",
        "ok": "2590",
        "ko": "-"
    },
    "percentiles4": {
        "total": "3247",
        "ok": "3247",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 88,
    "percentage": 37
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 34,
    "percentage": 14
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 118,
    "percentage": 49
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.875",
        "ok": "1.875",
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
        "total": "1095",
        "ok": "1095",
        "ko": "-"
    },
    "maxResponseTime": {
        "total": "4246",
        "ok": "4246",
        "ko": "-"
    },
    "meanResponseTime": {
        "total": "2379",
        "ok": "2379",
        "ko": "-"
    },
    "standardDeviation": {
        "total": "753",
        "ok": "753",
        "ko": "-"
    },
    "percentiles1": {
        "total": "2293",
        "ok": "2293",
        "ko": "-"
    },
    "percentiles2": {
        "total": "2916",
        "ok": "2916",
        "ko": "-"
    },
    "percentiles3": {
        "total": "3643",
        "ok": "3643",
        "ko": "-"
    },
    "percentiles4": {
        "total": "4069",
        "ok": "4069",
        "ko": "-"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 12,
    "percentage": 5
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 228,
    "percentage": 95
},
    "group4": {
    "name": "failed",
    "count": 0,
    "percentage": 0
},
    "meanNumberOfRequestsPerSecond": {
        "total": "1.875",
        "ok": "1.875",
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
