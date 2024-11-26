Feature: Ziyaretçi 2NHABER (https://2nhaber.com/) web sitesinin anasayfasında bulunan search butonuna tıklamalı.
        Açılan inputa “İstanbul” yazarak arama yapmalı ve çıkan sonuçların ilk sayfasındaki 8.haberin detayına gitmelidir.

  @
  Scenario: Ziyaretci Istanbul yazar ve 8. haberin detayına gider.
    Given Ziyaretci 2NHaber anasayfasına gider
    And Arama cubuguna "İstanbul" yazar
    Then Cikan sonuclardan 8'inci haberin detaylarına bakar