# springbootBank
國泰銀行練習

API
1. 新增 POST : http://localhost:8097/addBank

{
    "id":3,
    "code":"US",
    "description":"美元",
    "rate": "22.3",
    "updateTime": "2023/10/10"
}

2.刪除 DELETE : http://localhost:8097/deleteBank?id={id}

3.修改 PUT : http://localhost:8097/editBank

    {
        "id": 1,
        "code": "US",
        "description": "美元",
        "rate": "33.3",
        "updateTime": "2023/10/10"
    }

4.取所有值 GET : http://localhost:8097/getBank



5.取coindesk API 的值
http://localhost:8097/getOldData


