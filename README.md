# libmanager

work in progress...<br>
<br>*I've considered database, but decided that even h2 would be overkill for this set of requirements
<br>*Two classes have unconventional names: ListPrice_Offer and RetailPrice_Offer it's because duplicate names of properties in json file, underscore makes visual identification easier in this particular case much better than for example RetailPriceFromOffer
<br>*servlet server->embeded tomcat
<br>*lombok
<br>*spring boot
<br>*I assume that source file will be valid Json file
-----
<br>+Timestamp format can't be used - there are dates before 1970, and this format seems quite unfitting for publication date - to be clarified
<br>+List of strings will be used instead of array of Strings - as this should return json - it shouldn't make difference - to be clarified
