
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.zemberek.erisim.Zemberek;
import net.zemberek.tr.yapi.TurkiyeTurkcesi;
import net.zemberek.yapi.DilAyarlari;
import net.zemberek.yapi.Kelime;
import net.zemberek.yapi.Kok;
import net.zemberek.yapi.ek.Ek;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ASUS-PC
 */
public class MorphParser {

    private final Zemberek tr;

    public MorphParser(DilAyarlari dil) {
        tr = new Zemberek(dil);
    }

    public String convert(String search, String replace) {
        Kelime[] srcParses = tr.kelimeCozumle(search);
        List<Ek> ekler = srcParses[0].ekler();
        Kelime[] replaceParses = tr.kelimeCozumle(replace);
        Kok kok = replaceParses[0].kok();
        return tr.kelimeUret(kok, ekler);
    }

    public Kelime[] parse(String word) {
        return tr.kelimeCozumle(word);
    }

}
