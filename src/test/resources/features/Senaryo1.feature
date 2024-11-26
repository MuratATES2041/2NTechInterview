Feature: Ziyaretçi 2NHABER (https://2nhaber.com/) web sitesindeki bütün navbar elementlerine tıklayabilmeli
        ve sayfalar sorunsuz açılmalı.
@a
  Scenario: Navbar Elementleri Kontrol
    Given Ziyaretci 2NHaber anasayfasına gider
    Then Navbarda bulunan elementlere tiklar ve dogru sayfanin acildigini kontrol eder

