### Features
- Driver can create account
- Client or passenger can 

## Create Driver

``` json
{
    "id": "f5e82bc8-1011-4eef-8ec9-46fdcb481530",
    "status": "DENIED",
    "driverApproveStatus": "SCHEDULED",
    "driverType": "TAXI",
    "rating": null,
    
    "lastKnownLocation": {
        "id": "b92a2661-e551-48cc-8c08-7ebb43c04e64",
        "latitude": 2222.0,
        "longitude": 2222.0
    },
    
    "home": {
        "id": "b92a2661-e551-48cc-8c08-7ebb43c04e64",
        "latitude": 2222.0,
        "longitude": 2222.0
    },
    
    "isAvailable": null
}
```
## Create Client
``` json
{
    "id": "44db37ae-4d8d-4fc9-901f-a9568df1bc37",
    "firstName": "anas",
    "email": "anas.abbal10@gmail.com",
    "phone": "0766539731",
    "role": null,
    "gender": "MALE",
    "home": {
        "id": "efd11661-bad7-4022-8138-07eb25338ca0",
        "latitude": 2222.0,
        "longitude": 2222.0
    },
    "work": {
        "id": "bfb3f93c-54d3-4dae-97b2-216f15ad2ed9",
        "latitude": 2222.0,
        "longitude": 2222.0
    },
    "driverDto": null
}
```
## Send Request to driver => NotificationDriver
``` json
{
            "id": "9c9e1c03-a041-4944-a2b7-b385dbddf2e8",
            "customers": [
                {
                    "id": "44db37ae-4d8d-4fc9-901f-a9568df1bc37",
                    "firstName": "anas",
                    "phone": "0766539731",
                    "gender": "MALE",
                    "home": {
                        "id": "efd11661-bad7-4022-8138-07eb25338ca0",
                        "latitude": 2222.0,
                        "longitude": 2222.0
                    },
                    "work": {
                        "id": "bfb3f93c-54d3-4dae-97b2-216f15ad2ed9",
                        "latitude": 2222.0,
                        "longitude": 2222.0
                    },
                    "lastKnownLocation": {
                        "id": "57ca5c36-b361-4edb-b74b-d29d6aecd894",
                        "latitude": 2222.0,
                        "longitude": 2222.0
                    },
                    "driver": null
                }
            ]
        }
```
## Accept request
``` json
{
            "id": "9c9e1c03-a041-4944-a2b7-b385dbddf2e8",
            "customers": [
                {
                    "id": "44db37ae-4d8d-4fc9-901f-a9568df1bc37",
                    "firstName": "anas",
                    "phone": "0766539731",
                    "gender": "MALE",
                    "home": {
                        "id": "efd11661-bad7-4022-8138-07eb25338ca0",
                        "latitude": 2222.0,
                        "longitude": 2222.0
                    },
                    "work": {
                        "id": "bfb3f93c-54d3-4dae-97b2-216f15ad2ed9",
                        "latitude": 2222.0,
                        "longitude": 2222.0
                    },
                    "lastKnownLocation": {
                        "id": "57ca5c36-b361-4edb-b74b-d29d6aecd894",
                        "latitude": 2222.0,
                        "longitude": 2222.0
                    },
                    "driver": {
                        "id": "f5e82bc8-1011-4eef-8ec9-46fdcb481530",
                        "status": "DENIED",
                        "driverApproveStatus": "SCHEDULED",
                        "driverType": "TAXI",
                        "rating": null,
                        "lastKnownLocation": {
                            "id": "b92a2661-e551-48cc-8c08-7ebb43c04e64",
                            "latitude": 2222.0,
                            "longitude": 2222.0
                        },
                        "home": {
                            "id": "b92a2661-e551-48cc-8c08-7ebb43c04e64",
                            "latitude": 2222.0,
                            "longitude": 2222.0
                        },
                        "isAvailable": "IN-RIDE"
                    }
                }
            ]
        }
``` 
## Notification Client
``` json
{
            "id": "8a81688f-308b-48fd-adb6-afe4028a04de",
            "drivers": [
                {
                    "id": "f5e82bc8-1011-4eef-8ec9-46fdcb481530",
                    "status": "DENIED",
                    "driverApproveStatus": "SCHEDULED",
                    "driverType": "TAXI",
                    "rating": null,
                    "lastKnownLocation": {
                        "id": "b92a2661-e551-48cc-8c08-7ebb43c04e64",
                        "latitude": 2222.0,
                        "longitude": 2222.0
                    },
                    "home": {
                        "id": "b92a2661-e551-48cc-8c08-7ebb43c04e64",
                        "latitude": 2222.0,
                        "longitude": 2222.0
                    },
                    "isAvailable": "IN-RIDE"
                }
            ]
        }
``` 
