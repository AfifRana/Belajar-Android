package com.example.mysubmission.model;

import java.util.ArrayList;

public class FoodsData {
    public static String[][] data = new String[][]{
            {"Nasi Padang", "Nasi Padang Boga Rasa" , "Rp. 18.000" , "Dedikasi Boga Rasa sebagai Rumah Makan Padang murah bagi mahasiswa akan selalu dipegang. Boga Rasa selalu konsisten menjaga kualitas makanannya. Sudah banyak yang membuktikan kelezatan nasi padang Boga Rasa yang berani diadu dengan rumah makan Padang yang lain. Tertarik mencoba?" ,
                    "https://awsimages.detik.net.id/community/media/visual/2019/03/05/cd583520-7404-4f27-82eb-a281d9baac67.jpeg"},
            {"Pecel Lele", "Pecel Lele Ali Action", "Rp. 16.000" , "Ali Action adalah Raja Seafood Kuningan. Menjadi salah satu destinasi wisata kuliner yang sering dikunjungi oleh wisatawan domestik maupun mancanegara. menu Pecel Lele ini selalu menjadi andalan. Kualitas BIntang 5, tapi harga bersahabat, hanya di Ali Action." ,
                    "http://blog.nuhun.online/foto_berita/74111.jpg"},
            {"Siomay", "Siomay Mekarsari", "Rp. 8.000" , "Siomay ini dibuat dengan campuran daging asli yang diolah dengan kualitas terbaik. Empuk dan menggoda di lidah. Bumbunya sangat menendang, bisa membuat Anda selalu ketagihan." ,
                    "https://asset-a.grid.id/crop/0x0:0x0/700x465/photo/sasefoto/original/39425_siomay-gulung-sayur.JPG"},
            {"Bakso", "Bakso Sony Lampung", "Rp. 12.000" , "Bakso Sony bermarkas utama di Tanjung Karang, Lampung. Namun kini Bako Sony telah memiliki berbagai cabang di Sumatera, Jawa, dan Kalimantan. Bakso Sony  ternominasi menjadi salah satu bakso terlezat di Indonesia. Anda tertarik membuktikannya?" ,
                    "http://4.bp.blogspot.com/-JuDpxZTyzhg/USVyksp_UzI/AAAAAAAAAzM/u_EUgXeQ3fE/s1600/Resep+masakan+bakso+sapi+kuah+Paling+Enak+dan+Sedap.jpg"},
            {"Mie Ayam", "Mie Ayam Mas Pri", "Rp. 10.000" , "Mie Ayam Mas Pri sudah memiliki puluhan cabang yang tersebar di pulau Jawa. Mie Ayam ini sudah menjadi primadona baik di kalangan pelajar, karyawan, hingga ibu rumah tangga. Harganya yang berani beradu saing tidak mengurangi cita rasa kelezatannya. Bila Anda tertarik, silakan mencoba." ,
                    "https://awsimages.detik.net.id/community/media/visual/2018/07/13/b09e3840-0310-420f-806e-871c8d954f8a.jpeg"},
            {"Cuanki", "Cuanki Mang Jak", "Rp. 8.000" , "Sejak 1987 Mang Jak sudah melayani ribuan mahasiswa kampus untuk menikmati cuanki sedap yang memanjakan lidah. Kuah cuankinya yang khas membuat para alumni bahkan mengenang betapa lezatnya cuanki ini. Sekali mencoba, dijamin datang  lagi besok untuk membeli." ,
                    "https://cdn2.tstatic.net/tribunnews/foto/bank/images/cuanki-bandung_20151019_080512.jpg"},
            {"Soto", "Soto Lamongan Pak Bewo", "R. 15.000" , "Kami sudah buktikan selama 25 tahun menyajikan makanan terbaik bagi banyak orang. Sudah banyak orang yang membuktikan kualitas soto lamongan kami berbeda dari yang lainnya. Anda mau membuktikannya? Silakan bila Anda tertarik." ,
                    "https://awsimages.detik.net.id/community/media/visual/2017/03/22/d3cb3b7a-aa3a-4e0a-a0d4-83828a40b5d5_11.jpg"},
            {"Nasi Goreng", "Nasi Goreng Pertigaan Citra", "R. 13.000" , "Campuran telur, ayam, timun, dan tomatnya disajikan sangat pas. Kematangan nasi begitu sempurna, membuatnya terasa benar-benar berbeda dari nasi goreng lainnya tentunya. Dijamin pasti Anda suka!" ,
                    "https://cdn0-production-images-kly.akamaized.net/dnGlSowKdwt0ugtuOmduf8D4dm0=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/1359428/original/084420000_1475132767-Black-pepper-petai-fried-rice.jpg"},
            {"Sate", "Sate Bu Lala Area", "R. 20.000" , "Daging pilihan yang diseleksi langsung dipertenakan. Untuk menghasilkan kualitas sate nomor satu yang pernah ada. Bumbu kacang yang menggoda selera selalu bikin nagih teruss.." ,
                    "http://www.dapurkobe.co.id/wp-content/uploads/sate-ayam.jpg"},
            {"Mie Goreng", "Warmindo Ala Ciwaruga", "R. 7.000" , "Mie Goreng yang sudah terkenal dengan kelezatan dan cita rasanya yang begitu menggoda selera. Dengan campuran telur dan kuah kaldunya yang mantap, membuatnya jadi andalan, terutama di akhir bulan bagi mahasiswa." ,
                    "https://cdns.klimg.com/merdeka.com/i/w/news/2018/05/30/981995/670x335/resep-mie-goreng-rev-1.jpg"},
    };

    public static ArrayList<Food> getListData(){
        ArrayList<Food> list = new ArrayList<>();
        for (String[] aData : data) {
            Food food = new Food();

            food.setName(aData[0]);
            food.setFrom(aData[1]);
            food.setPrice(aData[2]);
            food.setNotes(aData[3]);
            food.setPhoto(aData[4]);

            list.add(food);
        }

        return list;
    }
}
