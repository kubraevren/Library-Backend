# 📚 Kütüphane Yönetim Sistemi (Library Management System)

Bu proje, kütüphane işlemlerini (kitap ekleme, üye takibi, ödünç alma vb.) dijital ortamda yönetmek amacıyla geliştirilmiş, **RESTful mimariye sahip** bir Backend projesidir.

Geliştirme sürecinde modern yazılım prensipleri (**Clean Code**, **DTO Pattern**, **Global Exception Handling**) dikkate alınmış ve gerçek hayat senaryolarına uygun validasyonlar (doğrulamalar) eklenmiştir.

## 🚀 Kullanılan Teknolojiler

Proje altyapısında aşağıdaki güncel teknolojiler kullanılmıştır:

* **Java 17**: Ana programlama dili.
* **Spring Boot 4.0.0**: Hızlı ve modern uygulama geliştirme çatısı.
* **PostgreSQL**: Verilerin tutulduğu ilişkisel veritabanı.
* **Spring Data JPA / Hibernate**: Veritabanı ile nesne tabanlı (ORM) iletişim.
* **Lombok**: Kod tekrarını azaltmak ve daha temiz entity sınıfları için.
* **Maven**: Bağımlılık (Dependency) yönetimi.
* **Hibernate Validator**: Gelen verilerin doğruluğunu kontrol etmek için.

## 🛠 Projenin Özellikleri (Yetkinlikler)

Bu projeyi geliştirirken odaklandığım temel backend yetkinlikleri:

* **Kullanıcı Yönetimi:** Güvenli kullanıcı kaydı ve giriş (Login) işlemleri.
* **CRUD İşlemleri:** Kitap ekleme, silme, güncelleme ve listeleme fonksiyonları.
* **DTO (Data Transfer Object) Deseni:** Veritabanı nesnelerini (Entity) dış dünyadan gizleyerek, sadece gerekli veriyi taşıyan güvenli bir yapı kuruldu.
* **Global Exception Handling (Merkezi Hata Yönetimi):** Uygulama genelinde oluşabilecek hatalar (örn: "Kitap bulunamadı" veya "Kullanıcı zaten kayıtlı") tek bir merkezden yakalanıp, istemciye anlamlı ve düzgün formatta hata mesajları dönüldü.
* **Validasyonlar:** Kullanıcıdan gelen verilerin doğruluğu kontrol edildi (Örn: Sayfa sayısı negatif olamaz, Kitap adı boş bırakılamaz).

## ⚙️ Kurulum ve Çalıştırma

Projeyi kendi bilgisayarınızda çalıştırmak için şu adımları izleyebilirsiniz:

1.  **Projeyi İndirin (Clone):**
    ```bash
    git clone [https://github.com/kubraevren/library.git](https://github.com/kubraevren/library.git)
    cd library
    ```

2.  **Veritabanı Ayarları:**
    * Bilgisayarınızda PostgreSQL'in kurulu olduğundan emin olun.
    * `postgres` adında bir veritabanı oluşturun (veya `application.properties` dosyasından adı güncelleyin).
    * `src/main/resources/application.properties` dosyasındaki `username` ve `password` alanlarını kendi yerel ayarlarınıza göre düzenleyin.

3.  **Uygulamayı Başlatın:**
    Proje dizininde terminali açıp aşağıdaki komutu çalıştırın:
    ```bash
    ./mvnw spring-boot:run
    ```

## 📍 API Uç Noktaları (Endpoints)

Projedeki servislerin tam listesi, hangi parametreleri aldığı ve örnek istek/cevapları için ana dizindeki [ENDPOINTS.md](ENDPOINTS.md) dosyasını inceleyebilirsiniz.

**Hızlı Bakış:**

| Metot  | URL           | Açıklama                     |
| :----- | :------------ | :--------------------------- |
| POST   | `/user/login` | Kullanıcı Girişi             |
| GET    | `/books`      | Tüm Kitapları Listele        |
| POST   | `/books`      | Yeni Kitap Ekle              |
| DELETE | `/books/{id}` | Kitabı Sil (ID'ye göre)      |

---
*Bu proje **Kübra Evren** tarafından, Backend geliştirme yetkinliklerini pekiştirmek amacıyla geliştirilmiştir.*