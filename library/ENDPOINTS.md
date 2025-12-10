# 📚 Library API Endpoint Dokümantasyonu

Bu proje, kitap ve kullanıcı yönetimini sağlayan RESTful bir API servisidir.

## 👤 Kullanıcı İşlemleri (User Controller)

| Metot | URL           | Açıklama                                   | Örnek İstek (Body) |
|-------|---------------|--------------------------------------------|-------------------|
| POST  | `/user`       | Sisteme yeni kullanıcı kaydeder.           | `{"username": "kubra", "email": "test@mail.com", "password": "123"}` |
| POST  | `/user/login` | Kullanıcı girişi yapar (Bilgileri doğrular)| `{"email": "test@mail.com", "password": "123"}` |

## 📖 Kitap İşlemleri (Books Controller)

| Metot | URL           | Açıklama                                      | Örnek İstek (Body) |
|-------|---------------|-----------------------------------------------|-------------------|
| GET   | `/books`      | Kayıtlı tüm kitapları listeler.               | - |
| POST  | `/books`      | Yeni kitap ekler. (Seri No/ID manuel girilir) | `{"serialNo": 101, "title": "Java", "author": "Yazar", "pageCount": 100, "status": "READ", "userId": 1}` |
| PUT   | `/books/{id}` | Var olan bir kitabı günceller.                | `{"serialNo": 101, "title": "Java v2", ...}` |
| DELETE| `/books/{id}` | ID'si verilen kitabı siler.                   | - |

## ⚠️ Hata Kodları

- **200 OK:** İşlem başarılı.
- **400 Bad Request:** Eksik veya hatalı veri (Validation hatası).
- **404 Not Found:** Kullanıcı veya kitap bulunamadı.
- **500 Internal Server Error:** Beklenmedik sunucu hatası.