package com.latihan.pakaianadat;

import java.util.ArrayList;

public class Data_pakaian {
    public static String[][]data = new String[][]{
            {"Ulee Balang (N.A.D)", "Nangroe Aceh Darussalam sangat terkenal dengan keanekaragaman budayanya yang khas. Salah satunya adalah pakaian adatnya yang bernama Ulee Balang. Pakaian adat Ulee Balang ini biasanya hanya dipakai oleh para raja Aceh dan keluarga-keluarga kerajaan dalam acara sakral kerajaan ataupun upacara adat tertentu.", "https://i1.wp.com/www.romadecade.org/wp-content/uploads/2018/08/pakaian-adat-indonesia-Pakaian-Adat-Ulee.jpg?w=800&ssl=1"},
            {"Betawi (Jakarta)", "DKI Jakarta memang dikenal dengan suku betawinya yang sangat dominan. Begitu juga dengan pakaian adatnya yang berasal dari pakaian adat betawi, Pakaian adat ini terkenal dengan menggunakan sarung untuk kaum laki-laki dan kerudung untuk kaum perempuan.", "https://i0.wp.com/www.romadecade.org/wp-content/uploads/2018/08/Pakaian-Adat-Betawi.jpg?w=800&ssl=1"},
            {"Kebaya (Jawa Barat)", "digunakan oleh berbagai kalangan mulai dari bangsawan hingga masyarakat biasa, namun pakaian adat dari Jawa Barat ini memiliki masing-masing perbedaan, Terutama yang digunakan untuk kaum laki-laki dan perempuan Untuk membedakan golongan, perbedaan terletak pada bahan dan corak yang digunakan untuk membuat pakaian adat ini.", "https://i2.wp.com/www.romadecade.org/wp-content/uploads/2018/08/Pakaian-Adat-Tradisional-Kebaya.jpg?w=800&ssl=1"},
            {"Jawi Jangkep (Jawa Tengah", "Jawi Jangkep merupakan salah satu pakaian adat khusus pria. Pakaian ini merupakan pakaian resmi yang berasal dari Jawa Tengah,  Jawi Jangkep terdiri dari atasan yang berupa baju beskap yang biasanya memiliki motif bunga, sedangkan untuk bawahannya berupa kain jarik yang dililitkan pada ikat pinggang yang tersedia. Selain itu tadi, untuk menambah kesan tampan dan mempesona perlu ditambahkan beberapa aksesoris pelengkap, seperti keris, alas kaki, blangkon untuk penutup kepala dan bunga melati yang dililitkan di bagian leher.", "https://perpustakaan.id/wp-content/uploads/2018/11/pakaian-adat-jateng.jpg"},
            {"Perang (Kalimantan Barat)", "Pakaian adat dari Kalimantan Barat adalah sejenis pakaian perang yang terbuat dari bahan dasar kayu yang diolah menjadi kain. Kayu yang digunakan tak sembarang kayu pada umumnya, kulit kayu yang dipakai adalah dari kayu ampuro, Keahlian para masyarakat Kalimantan dalam membuat pakaian adat ini adalah warisan turun temurun dari nenek moyang mereka.", "https://i2.wp.com/www.romadecade.org/wp-content/uploads/2018/09/Suku-Dayak-Dari-Kalimantan-Barat.jpg?w=800&ssl=1"},
            {"Nggembe (Sulawesi)", "Pakaian nggembe di Sulawesi ini dikenal dengan bentuknya yang segi empat, berlengan lebar, berkerah bulat, dan memiliki panjang hingga pinggang, Jenis pakaian adat ini digunakan bukan untuk sembarang acara melainkan hanya dalam acara-acara penting tertentu saja. Misalnya seperti upacara adat ataupun acara pernikahan.", "https://i2.wp.com/www.romadecade.org/wp-content/uploads/2018/09/Suku-Minahasa-Dari-Sulawesi-Utara.jpg?w=800&ssl=1"},
            {"Baju Cele (Maluku)", "Baju Cela khas Maluku memiliki corak dengan ciri-ciri kotak kecil dengan geometris yang bergaris-garis. Pada umumnya baju Cele ini dipadukan dengan kain sarung yang memiliki warna yang hampir sama. Pakaian adat ini hanya digunakan dalam upacara adat Provinsi Maluku saja.", "https://i2.wp.com/www.romadecade.org/wp-content/uploads/2018/08/Pakaian-Adat-Baju-Cele-Provinsi-Maluku.jpg?w=800&ssl=1"},
            {"Billu  & Mukuta (Gorontalo)", "Biasa disebut dengan Billu untuk kaum perempuan dan Mukuta untuk kaum pria, pakaian adat khas Gorontalo ini biasanya digunakan dalam acara sakral pernikahan", "https://i0.wp.com/www.romadecade.org/wp-content/uploads/2018/08/Pakaian-Adat-Provinsi-Gorontalo.jpg?w=800&ssl=1"},
            {"Pakaian adat tradisional Kalimantan Tengah", "Dalam kehidupan masyarakat Kalimantan tengah Pengantin lak-laki harus memakai celana panjang yang mencapai lutut, tali pinggang, selempit perak, dan memakai tutup kepala. Selain itu juga memakai perhiasan yang terdiri dari inuk atau kalung yang panjang ,cengkoang yang di buat dari gigi hewan. Untuk wanita nya sendiri memakai kain berupa rok yang pendek, ikat kepala, kalung, subang, hiasan bulu enggang dan rompi.", "https://moondoggiesmusic.com/wp-content/uploads/2018/05/pakaian-adat-kalimantan-tengah.jpg"},
            {"Pakaian adat tradisional Kalimantan Timur", "Berada di ujung utara dari pulau Kalimantan. Meskipun wilayahnya yang luas yaitu sekitar 75.467,70 km², namun jumlah populasi penduduknya tergolong sedikit yaitu sekitar 600 ribu jiwa. Sebagian besar penduduknya didominasi oleh suku Dayak, Walaupun terlihat sama dengan pakaian adat dari Kalimantan Timur, namun pakaian ini tetap memiliki perbedaan dan ciri khas tersendiri.", "https://moondoggiesmusic.com/wp-content/uploads/2018/05/pakaian-adat-kalimantan-utara.jpg"},
    };
    public static ArrayList<Pakaian> getPakaian(){
        ArrayList<Pakaian> list = new ArrayList<>();
        for (String[]data2 : data){
            Pakaian pakaian = new Pakaian();
            pakaian.setNama(data2[0]);
            pakaian.setKeterangan(data2[1]);
            pakaian.setGambar(data2[2]);
            list.add(pakaian);
        } return list;
    }
}
