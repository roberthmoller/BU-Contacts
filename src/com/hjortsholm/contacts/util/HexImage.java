package com.hjortsholm.contacts.util;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

public class HexImage {
    private Image image;
    public HexImage(String data) {
        this.image = null;
        try {
            byte[] imageInByte = new BigInteger(data, 16).toByteArray();
            InputStream in = new ByteArrayInputStream(imageInByte);
            BufferedImage bImageFromConvert = ImageIO.read(in);
            this.image = SwingFXUtils.toFXImage(bImageFromConvert, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public Image getImage() {
        return image;
    }

    private static String hex = "89504E470D0A1A0A0000000D494844520000012C0000012C08030000004EA37E4700000243504C5445E4E6E7E5E7E8E3E5E6E0E3E4DEE0E1DBDDDFD8DADCD6D9DAD5D8D9D4D6D8D4D7D9D5D8DAD6DADBD9DCDDDCDFE0DFE1E2E1E3E4E5E6E7E5E7E7E1E4E5DBDEDFD3D6D8C9CDCFC1C6C8BBC0C3B6BCBEB3B9BCB1B7BAB0B6B9AFB5B8AFB6B9B1B6B9B2B8BBB4BABDB8BEC0BEC3C5C5C9CBCED1D3D7DADCDCDEE0CFD2D4B7BCBFAEB4B7ADB4B7B4B9BCBCC1C3C8CCCEE4E7E8DADDDEB9BEC1B1B7B9AFB4B7B4BABCC0C5C7D2D5D7E0E2E3CED2D3BAC0C2ADB3B6C4C8CAD7DADBE2E4E5C6CACDD0D4D6D8DCDDC3C8CAB2B8BAB9BEC0B2B7BAD2D5D6CBCFD1BEC2C5BBC0C2C7CBCDDFE2E3D6D9DBD8DBDDB9BFC1CFD3D4DDDFE1C6CBCDAEB3B6DEE0E2DCDEDFCCCFD1B0B5B8DBDDDEDDE0E1B8BDBFD0D3D4D4D8D9E3E6E7B6BCBFD1D5D6BDC2C4B5BABDE1E3E5BDC3C5D2D6D7CACDD0D8DBDCE4E5E6C6CACCC2C7C9D9DBDDB3B9BBDDDFE0DFE1E3AEB4B6CCD0D2D1D5D7C0C4C7CDD1D2BDC2C5D1D4D6ADB4B6B8BDC0C3C7C9E2E4E6E4E6E8B5BBBDCDD0D2C4C8CBCACED0AFB6B8BABFC2E3E4E5AEB5B8D0D3D5B7BDC0AEB5B7BDC1C4ADB3B7CACDCFD0D4D5E2E3E5CCD0D1C5C9CCC2C6C8B6BBBEBCC1C4D5D9DABFC3C6DEE1E2DADCDEE3E5E7D9DCDEB3B8BBBFC4C6C4C9CBCDD1D3C5CACCB7BDBFE2E5E6D4D7D8AEB3B7BBC1C3E4E6E6D7D9DBCBCFD0AEB4B8CFD3D5BEC3C6D3D7D8DADCDDE3E6E6BABFC1CED2D4B0B7B9C2C6C9DADDDFC3C7CAE5E6E8C1C5C7B7BCBECED1D4C7CBCEB0B6B8CBCED0CACECFC7CCCECDD2D3AFB4B8D3D6D7B4B9BBBCC0C3E3E4E6C9CDD0E0E2E4C1C5C8B0B5B9B5BBBECCCFD21C273F22000008C84944415478DAEDDDEB5F14D71907F06746102AB2BB202CC8CED4E5A6EC6F01596E6B47B6544209088A8A041B23584B5835A1260A8D971AAD521385440D2A315ADB6AA3BDA4F736BD37FDD32A262A46A2C0CE9C9D73E6F9BEDD77CFE79C67CFF39CCB10638C31C618638C31C618638C31C618638C31C618638C31C618638C31C618638C31C618638C31C618638C31E62A1AE9CB32329767657F6D45CECA5C9F3FA06B79C49E92AFAD2A280C1615AF2E091986699A5F37D6844BCBCA2B2AD7FA758DD8639ABEAEAA28123211C553CCEA9ADA9C65DA7A62B3F4BA60AC1ECFD2D0D8D41C2746FE0DDF302D3C5FF5C69604799A5EF7CD520B0B639935AD1E1E5EFAB736B55958B8285ED8E0D570ADAB68B7B058B16F7B70326A818E522C85F9E25AF29AACCE062C51B86B3379C9B2AE7AA4A0AC9BBCA3670B526304BD92B9F4ADED1652142DEF252F58B5CD44EAB647B2487D3B9A608F92569D14D7570CBBD4EF543C5A7531D8A73FA874B45E8AC04E662DA9AB2F027B994152D5C02ED8CDEC2035C56B2CD8CEF80EA928510427845F26F5EC0E9A70C42B99A49C3D6BE09041E51A82754370CCB6DDA494BDDF85738C7DA494EFC1494303A490E1109C6415BD4ACA58550C6799CDF9A488BC4A386D9732FF883B4AE138658AC41138AFA48094901986001B49094988D0364C0AD81F82104915DAA69B20465B2E492FF300C4885690F48210A5FA2049EEB50844797D9424F77D881393FC00847EC88230660B496D5D18E25892A7F8372C0834142089E96F4228A94FD6F48621923522F3CD95C34720D498CC25CFB805A1D6F491B47E1081605BDF2259F9FA21D8B8B4494B6BB620D80BD22EE2B59123102C2CED21E6F53510CDCC2649258E42B863B226AD817A88661D2749B53440B8415997A5AD106F4CD25A5A3B01F186FC2425EDB805E1DA25DD99D69A209E21EB5EEB20C4FBA1A40B2DFD24C4339B494A6F9741BC53A7494A891F210DAA484A8908D260839C4FFCA429587216873C0DDD9EE0CF489AE079E9B01867219E29E98D3AED100493B8DCD1364E40B890AC85F48F215EA9A42D9ABC7310AF6C2FC9A9BB01C29D95B5AD7CD080701B657D32F79DA310EE5D69EFD27542347305494A3B6F41B0761FC96A8F05C1C6A43D1842052604BB206783665662128255C9FA67785FF2088432242D761E68B5205444DE9445E40B4124AB42DE9445A44F41A8F74866A3510854BD8C6496D90E71AC4D2435FD7D8822FBD59DFBCE4110890FB23D7271358491FF65C92E8852226F11FDD0A53004D9749964F76A12628424DD0413F52ADB5CDB8B64EDBE3FA1082284D4F868CA07210890943F633D703C0AC74D5F2235F496C0715DA488F53BB7C3619392EEDACF23B0C582B34ECBDCC8FA926E034E8A5E5162D9F0502D1CA346A133577C0ACE31CF915A721BE198AB4A4DC2595B0D38A4539D7FC287F42E3863488157249F12B8022784147B39FF0BFE2D13B05DFF3552936F12766B50E6B5EEA7D4D9112D354BC279F4D81CAD19E5160D73F57C08FB98DB643E0722F6038746F03A29EE6039ECD15EA9F41CFC5C7C13EC30F41179813E6A2065C5329FF15B94EE5D488D3922FBB18685CBDB7CD5400A2285E4257A610C4B15BA9AA1501379415EAB9DBE812568B899FD13F29E4B178C092C56A4CA3BD9EA09FAAD26C3C2624C765C24CFD2978FB75958180BB16BEAF5441767E0A763261620DC94BD8A3C2FFFFAF29188816769987EB3CAEB83EA112DD1D3F1FE51E3679887198E1D6FDE415E5B2C3C93469B7B7E3E723B36D46698E6299C314D2334BDFAE685131FF9121CA879E46BFA5E7FDF707661F3E1C3CD776E5DEA8DBFCD238A3161F2348DF44420BEA3B7A0A0EE17B9FB733FA82B58D7EB8FBFA3EFCED7B43C9E8D0F7C9C88F7B5341FAB1D7FF16E64A8245C6F98F7010DA669F61BA170E9E458E795ABC17B85FB079679A031FA9512FEBAC28EF1A948B87FC2B22C6CC7578946677FFF6575D9ED99CAAC75018FC5EC72C097339A3C596D4C585814CB4268F2ECCCD6E18B8A6FEB7C2E4FDFBCFC8D5FC5C2A68525B32CA3B166E4F0AF0324F155FBE7C9A778D6892B9306EC60211CFBCDBD3A3517AC9F240AEEFD76D280BDDA632377542B85B4C470EDDD101C6196946FF0A913AFC4CA9957CC1B7050A878B44F855E73627FEDEF60C1699651F3FB5EB91715BAAFE3A469410C2B7C685F9C6415C8494E5B10C8C287C13A298757C6B193FD16840B37DD09C896ED0BFE308934F96367555CA670E58E87914E913FF96509576E513DD26DE8CF3284EBE3E126E306D2EFF5EAA0EBF7635F4A1A16DCC1AADEE9EA9544C65FC26E09D5AC89B156D7EECB06FE3A09973107BBDDB9EECA9A32E13EA18ADE4FC865B481AB21B8D364A5DBDAAACDAE9B818F7D5A5EE0A6D7A933926E9C818F1DB8E69AC1A5EF1972D37FE0BC06EBC815FCE7DD3DAC1E88369ED629FDD69E8414CCE37E4A33BD721AB2B89B4B69159891600A3ED2D84CCF23C30D2F418C6082D2653802C998459B293DFEF677C8E71F3E4A03FDDA1AC828D243C2E9419952FB5C8D5924985E7B0AB23A90A39148FFEC92755CCD2A5941022546648E15305D48C2E8B572C70A28C92641F47FC91E2BA0FA1609A1BF2B7FAC80D21E12A1D58002A2111F39AF3B0C2544A7E2E4B4021737DB1729799D9C15B809659C3A41CE9A8142422BC849A79548EE8FACF69173F697402DE50172CABF6BA01AE7D25610CA696B2167AC6C837A3AE3E48465C55051909C300A25B5654AFAD58E74B00E91FD92AE3FFCB14466E15B64B3B52AF465E6175B45F6D26F43590D55F964A7BC1CB5EA9C278DC5C94E894128ECCCB13C1E580B561627FBE8FF81D2CC56B24FAE8A85CE5C5309B2CD7928EEBF3964978B9F4171565297F1C3D969523D60DB27D955AD74E6A8227B14B4437D833AD9A27202EA0B1DE4B270C1ACD364870C45F6EB9FE30AD9619F07D23B800371B24185378285164ADDE5BBF004AB43A3945D74EB755EBBDDCEA394BD078F38BA97529537EA919405C347A9D2C6E1152F53CA24B9A86A83FF6994A240293C223AAE518A06BCF267080C52AA2EA9BBB9FA65319D5294F329BCE2B300A5A8B92DEC15ABFD94A2C4408667B8F3F528C618638C31C618638C31C618638C31C618638CCDF17F2883BDAB1424CA070000000049454E44AE426082";

    public static String getHex() {
        return HexImage.hex;
    }
}
