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
<br>+It is more suitable to use Wrapper formats as part of json fiels can be empty - if wrapper format is used field can be set to null
<br>+regarding:
    "Will return a book identified by the given ISBN number in the form of a JSON document or return
    a 404 if the book does not exists in the data set"
    what in case:
    item(book) in json have both ISBN and id -> when using (/api/book/{isbn}) should this book be found by id? If yes per requirements book will be shown with only its ISBN number - to be clarified
<br>What about ISBN-10    