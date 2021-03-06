var stats = {
    type: "GROUP",
name: "Global Information",
path: "",
pathFormatted: "group_missing-name-b06d1",
stats: {
    "name": "Global Information",
    "numberOfRequests": {
        "total": "2000",
        "ok": "711",
        "ko": "1289"
    },
    "minResponseTime": {
        "total": "1073",
        "ok": "1073",
        "ko": "14618"
    },
    "maxResponseTime": {
        "total": "60022",
        "ok": "55058",
        "ko": "60022"
    },
    "meanResponseTime": {
        "total": "35060",
        "ok": "20801",
        "ko": "42925"
    },
    "standardDeviation": {
        "total": "18854",
        "ok": "18243",
        "ko": "13926"
    },
    "percentiles1": {
        "total": "32508",
        "ok": "19958",
        "ko": "33493"
    },
    "percentiles2": {
        "total": "55422",
        "ok": "37623",
        "ko": "60005"
    },
    "percentiles3": {
        "total": "60012",
        "ok": "50038",
        "ko": "60013"
    },
    "percentiles4": {
        "total": "60014",
        "ok": "54476",
        "ko": "60015"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 25,
    "percentage": 1
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 686,
    "percentage": 34
},
    "group4": {
    "name": "failed",
    "count": 1289,
    "percentage": 64
},
    "meanNumberOfRequestsPerSecond": {
        "total": "17.241",
        "ok": "6.129",
        "ko": "11.112"
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
        "ok": "254",
        "ko": "746"
    },
    "minResponseTime": {
        "total": "1073",
        "ok": "1073",
        "ko": "17266"
    },
    "maxResponseTime": {
        "total": "60022",
        "ok": "53655",
        "ko": "60022"
    },
    "meanResponseTime": {
        "total": "43818",
        "ok": "25246",
        "ko": "50141"
    },
    "standardDeviation": {
        "total": "18000",
        "ok": "14588",
        "ko": "14298"
    },
    "percentiles1": {
        "total": "52238",
        "ok": "24679",
        "ko": "60004"
    },
    "percentiles2": {
        "total": "60007",
        "ok": "35840",
        "ko": "60009"
    },
    "percentiles3": {
        "total": "60013",
        "ok": "49739",
        "ko": "60014"
    },
    "percentiles4": {
        "total": "60016",
        "ok": "52224",
        "ko": "60017"
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
    "count": 253,
    "percentage": 25
},
    "group4": {
    "name": "failed",
    "count": 746,
    "percentage": 75
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.621",
        "ok": "2.19",
        "ko": "6.431"
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
        "ok": "457",
        "ko": "543"
    },
    "minResponseTime": {
        "total": "1091",
        "ok": "1091",
        "ko": "14618"
    },
    "maxResponseTime": {
        "total": "55058",
        "ok": "55058",
        "ko": "42767"
    },
    "meanResponseTime": {
        "total": "26302",
        "ok": "18330",
        "ko": "33011"
    },
    "standardDeviation": {
        "total": "15282",
        "ok": "19556",
        "ko": "3115"
    },
    "percentiles1": {
        "total": "32361",
        "ok": "2481",
        "ko": "32409"
    },
    "percentiles2": {
        "total": "32508",
        "ok": "37822",
        "ko": "32502"
    },
    "percentiles3": {
        "total": "46584",
        "ok": "50965",
        "ko": "42754"
    },
    "percentiles4": {
        "total": "53153",
        "ok": "54533",
        "ko": "42765"
    },
    "group1": {
    "name": "t < 800 ms",
    "count": 0,
    "percentage": 0
},
    "group2": {
    "name": "800 ms < t < 1200 ms",
    "count": 24,
    "percentage": 2
},
    "group3": {
    "name": "t > 1200 ms",
    "count": 433,
    "percentage": 43
},
    "group4": {
    "name": "failed",
    "count": 543,
    "percentage": 54
},
    "meanNumberOfRequestsPerSecond": {
        "total": "8.621",
        "ok": "3.94",
        "ko": "4.681"
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
