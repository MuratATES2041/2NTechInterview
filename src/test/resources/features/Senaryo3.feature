Feature: Ziyaretçi 2NTECH (https://www.2ntech.com.tr/hr) sitesinde bulunan formun 1.adımını eksiksiz doldurup
        2.adımında “Test Engineer” pozisyonunu seçmeli ve formu başarılı bir şekilde göndermelidir.
@wip
  Scenario: Ziyaretci formu doldurup Test Engineer pozisyonu icin basvuru ypacaktır
    Given Ziyaretci 2NTech HR sayfasına gider
    And Basvuru formunun ilk sayfasını doldurur
    And Basvuru sayfasının ikinci sayfasına gecer ve "Test Engineer" pozisyonunu secer
    Then Formun basarili bir sekilde gonderildigini kontrol eder