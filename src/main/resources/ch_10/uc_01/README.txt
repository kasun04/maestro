


GeoLocationToPostalCodeService
curl -v -X POST -H 'Content-Type: application/json' -d @resources/sample_resources/message_formats/GeoLocationToPostalCode_req.json http://localhost:9191/serviceorchestration/GeoLocationToPostalCodeService



PostalcodeToATMLocatorService

 curl -v -X POST -H 'Content-Type: text/xml' -H 'SOAPAction: urn:PostalcodeToATMLocatorService' -d @resources/sample_resources/message_formats/PostalcodeToATMLocatorService_req.xml http://localhost:9191/serviceorchestration/PostalcodeToATMLocatorService

GeoLocationToAddressService

 curl -v -X POST -H 'Content-Type: application/xml' -d @resources/sample_resources/message_formats/PostalcodeToATMLocatorService_req.xml http://localhost:9191/serviceorchestration/GeoLocationToAddressService


ATM Locator REST API


curl -v -X POST -H 'Content-Type: application/json' -d @resources/sample_resources/message_formats/ATMLocator_req.json http://localhost:8280/atm/locator
