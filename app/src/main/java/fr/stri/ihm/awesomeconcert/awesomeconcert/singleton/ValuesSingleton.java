package fr.stri.ihm.awesomeconcert.awesomeconcert.singleton;

import android.util.Log;

import org.stringtemplate.v4.ST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.stri.ihm.awesomeconcert.awesomeconcert.R;
import fr.stri.ihm.awesomeconcert.awesomeconcert.adapter.ConcertItem;
import fr.stri.ihm.awesomeconcert.awesomeconcert.adapter.CoverflowItem;
import fr.stri.ihm.awesomeconcert.awesomeconcert.adapter.StrategyItem;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Artist;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.Concert;
import fr.stri.ihm.awesomeconcert.awesomeconcert.entity.User;
import fr.stri.ihm.awesomeconcert.awesomeconcert.listeners.OnItemClickedListener;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 25/11/2016.
 */
public class ValuesSingleton {
    private static ValuesSingleton ourInstance = new ValuesSingleton();
    private static String TAG = "ValuesSingleton";

    public static ValuesSingleton getInstance() {
        return ourInstance;
    }

    private Map<Integer, Concert> mConcerts;
    private Map<Integer, Artist> mArtists;
    private boolean isLogged;
    private List<Integer> mConcertsNotif;
    private List<Integer> mArtistNotif;
    private Map<String, User> mUsers;
    private Map<String, List<Integer>> mUsersConcerts;
    private String mUser = "";

    private ValuesSingleton() {
        setupArtistData();
        setupConcertData();
        isLogged = false;
        mConcertsNotif = new ArrayList<>();
        mArtistNotif = new ArrayList<>();
        mUsers = new HashMap<>();
        mUsersConcerts = new HashMap<>();
        signUp(new User("admin", "", "", "", ""));
    }

    public Concert getConcertById(int id) {
        return mConcerts.get(id);
    }

    public Artist getArtistbyId(int id) {
        return mArtists.get(id);
    }

    public List<StrategyItem> generateExploreData(OnItemClickedListener listener) {
        List<StrategyItem> items = generateSearchData(listener);
        List<Concert> concerts = new ArrayList<>();
        for (int i = 0; i < mConcerts.size(); i++) concerts.add(mConcerts.get(i));
        items.add(0, new CoverflowItem(new ArrayList<>(concerts), listener));
        return items;
    }

    public List<StrategyItem> generateSearchData(OnItemClickedListener listener) {
        List<StrategyItem> items = new ArrayList<>();
        for (int i = 0; i < mConcerts.size(); i++) {
            items.add(new ConcertItem(i, mConcerts.get(i), listener));
        }
        return items;
    }

    public List<StrategyItem> generateConcertDataByArtistId(int artistId, OnItemClickedListener listener) {
        List<StrategyItem> items = new ArrayList<>();
        for (Concert concert : mConcerts.values()) {
            if (concert.getArtistId() == artistId)
                items.add(new ConcertItem(concert.getId(), concert, listener));
        }
        return items;
    }

    public List<StrategyItem> generateConcertsToNotify(OnItemClickedListener listener) {
        List<StrategyItem> items = new ArrayList<>();
        for (Concert concert : mConcerts.values()) {
            if ((mConcertsNotif.contains(concert.getId()) && !mArtistNotif.contains(concert.getArtistId())) || mArtistNotif.contains(concert.getArtistId())) {
                items.add(new ConcertItem(concert.getId(), concert, listener));
            }
        }
        return items;
    }

    public List<StrategyItem> generateUpcomingConcerts(OnItemClickedListener listener) {
        List<StrategyItem> items = new ArrayList<>();
        for(Concert concert : mConcerts.values()){
            if(mUsersConcerts.get(mUser).contains(concert.getId()))
                items.add(new ConcertItem(concert.getId(), concert, listener));
        }
        return items;
    }

    public void login(boolean login) {
        isLogged = login;
    }

    public void signUp(User user) {
        mUsers.put(user.getUserName(), user);
        mUsersConcerts.put(user.getUserName(), new ArrayList<>());
    }

    public boolean logUserIn(String user, String passwd) {
        isLogged = mUsers.get(user) != null && mUsers.get(user).isPasswdMatch(passwd);
        if(isLogged) mUser = user;
        return isLogged;
    }

    public boolean isLoggedIn() {
        return isLogged;
    }

    public User getCurrentUser() {
        return mUsers.get(mUser);
    }

    public void updateUser(String username, String name, String lastName, String mail) {
        mUsers.get(mUser).updateUser(username, name, lastName, mail);
    }

    public void updatePassword(String passwd) {
        mUsers.get(mUser).setPasswd(passwd);
    }

    public void notifArtist(int artistId, boolean notify) {
        Log.d(TAG, "Artist : " + artistId + " : notify ? " + notify);
        if(notify) if(!mArtistNotif.contains(artistId)) mArtistNotif.add(artistId);
        else mArtistNotif.remove(artistId);
    }

    public void notifyConcert(int concertId, boolean notify) {
        Log.d(TAG, "Concert : " + concertId + " : notify ? " + notify);
        if(notify) if(!mConcertsNotif.contains(concertId)) mConcertsNotif.add(concertId);
        else mConcertsNotif.remove(concertId);
    }

    public boolean notifEnabledArtist(int artistId) {
        Log.d(TAG, "Artist : " + artistId + " : enabled ? " + mArtistNotif.contains(artistId));
        return mArtistNotif.contains(artistId);
    }

    public boolean notifEnabledConcert(int concertId) {
        Log.d(TAG, "Concert : " + concertId + " : enabled ? " + mConcertsNotif.contains(concertId));
        return mConcertsNotif.contains(concertId);
    }

    public void buyTicket(int concertId) {
        mUsersConcerts.get(mUser).add(concertId);
    }


    public boolean hasTicket(int concertId) {
        return isLogged && mUsersConcerts.get(mUser).contains(concertId);
    }

    private void setupArtistData() {
        mArtists = new HashMap<>();
        mArtists.put(0, new Artist("Coldplay", R.drawable.coldplay, "Coldplay vient d'annoncer les premiËres dates 2017 de son A Head Full Of Dreams Tour.\n" +
                "Le 8 juin 2017 et le 15 juillet 2017, Coldplay nous fera honneur et l'immense plaisir de se produire ‡ Lyon au Stade Olympique Lyonnais et ‡ Paris au Stade de France pour deux concerts exceptionnels !\n" +
                "Depuis le mois de mars dernier, la tournÈe A Head Full Of Dreams Tour a comblÈ le public ‡ travers líAmÈrique Latine, les …tats-Unis et líEurope, avec notamment quatre dates historiques dans un Wembley Stadium de Londres ‡ guichets fermÈs. Plus de 2,5 millions de spectateurs ont dÈj‡ assistÈ ‡ ce show unique conÁu par le groupe avec le concours des cÈlËbres producteurs designers Misty Buckley et Paul Normandale.\n" +
                "Líalbum A Head Full Of Dreams síest vendu ‡ plus de 4 millions díexemplaires depuis sa sortie en dÈcembre 2015, portÈ par les hits Adventure Of a Lifetime, Hymn For The Weekend et Up&Up, totalisant plus díun milliard de vues sur Youtube. Un quatriËme single issu de líalbum, vient juste de sortir. La semaine derniËre, le groupe a ÈtÈ nominÈ pour 4 awards aux MTV EMA, dont le prestigieux award du meilleur live."));
        mArtists.put(1, new Artist("M Pokora", R.drawable.m_pokora, "AprËs un RED TOUR triomphal, M. POKORA est de retour sur scËne ‡ partir du 3 MARS 2017 et enflammera de nouveau la France, la Belgique et la Suisse avec un show spectaculaire entourÈ de 10 musiciens et ses danseuses."));
        mArtists.put(2, new Artist("Frero Delavega", R.drawable.frero_delavega, "Concert ÈvËnement aux Quinconces ‡ Bordeaux le 10 juin 2017 & en tournÈe dans toute la France ‡ partir du 02/03/17.\n" +
                "Flo et JÈrÈmy ont une histoire intime avec Bordeaux ; enfants de la rÈgion, ils offriront le 10 juin 2017 un concert díanthologie sur la place des Quinconces.\n" +
                "AprËs un passage par LíAccorHotel Arena/Paris, ils poseront enfin leurs valises dans la ville o˘ tout a commencÈ. Le duo complice devait bien cela aux Bordelais, toujours prÈsents, bienveillants et fiers de leurs artistes. "));
        mArtists.put(3, new Artist("Soprano", R.drawable.soprano, "SOPRANO DE RETOUR SUR SC»NE EN 2017\n" +
                "\n" +
                "Plus dí1 million díalbums vendus\n" +
                "500.000 ventes pour son dernier album Cosmopolitanie\n" +
                "Plus de 450 millions de streams audio/vidÈo\n" +
                "Plus de 350 000 spectateurs et 100 dates de concert pour le Cosmo Tour\n" +
                "Suivi par plus de 6 millions de personnes sur les rÈseaux sociaux\n" +
                "\n" +
                "SOPRANO va mettre le feu en concert dans toute la France avec un nouveau spectacle dËs mars 2017. "));
        mArtists.put(4, new Artist("Florent Pagny", R.drawable.florent_pagny, "Deux ans et demi aprËs le succËs de sa derniËre tournÈe ´ Vieillir Ensemble ª, Florent Pagny dÈcide pour son 55e anniversaire de remonter sur scËne et díoffrir ‡ son public une sÈrie de concerts exceptionnels dans toute la France avec sa nouvelle tournÈe ÈvÈnement ´ 55 Tour."));
        mArtists.put(5, new Artist("Les insus", R.drawable.les_insus, "AprËs plus de 6 mois de tournÈe ‡ guichets fermÈs, Les Insus (Jean-Louis AUBERT, Louis\n" +
                "BERTIGNAC, Richard KOLINKA et Aleksander ANGELOV) annoncent pour 2017 : le îDernier Appelî !\n" +
                "Ils reprendront la routÈ líÈtÈ prochain pour une sÈrie de concerts qui se conclura par une\n" +
                "date exceptionnelle vendredi 15 septembre au Stade de France !\n" +
                "´ On voulait que ce grand bonheur se finisse en beautÈ ! ª - Les Insus"));
        mArtists.put(6, new Artist("Stars 80", R.drawable.stars_80, "STARS 80 ñ 10 ANS DEJA !\n" +
                "Venez chanter et danser avec  les copains de STARS 80 , LIO, DEBUT DE SOIREE, SABRINA, FRANCOIS FELDMAN, JULIE PIETRI , COOKIE DINGLER, EMILE et IMAGES , PATRICK HERNANDEZ, JEAN PIERRE MADER, PHIL BARNEY, JEAN SCHULTHEIS, PAULINE ESTER, LAROCHE VALMONT, PATRICK COUTIN, rejoints cette saison par PLASTIC BERTRAND, THIERRY PASTOR, JONIECE JAMISON Ö. + invitÈs, distribution en cours et non exhaustive.\n" +
                "TOUS les Chanteurs, Musiciens 100%Live, Choristes et Danseurs, unis pour dÈlivrer UNE SPECTACLE UNIQUE, LE TEMPS DíUNE NUIT DE FOLIE !"));
    }

    private void setupConcertData() {
        mConcerts = new HashMap<>();
        addConcert(0, "PARC OLYMPIQUE LYONNAIS", "8/06/2017", 73);
        addConcert(0, "PARC OLYMPIQUE LYONNAIS", "18/07/2017", 180);
        addConcert(0, "STADE DE FRANCE", "18/07/2017", 84);
        addConcert(1, "ZENITH DE TOULOUSE", "23/04/2017", 55);
        addConcert(2, "PLACE DES QUINCONCES", "10/06/2017", 45);
        addConcert(3, "ZENITH DE TOULOUSE", "18/03/2017", 34);
        addConcert(4, "LE PALIO", "7/10/2017", 0);
        addConcert(5, "AMPHITHEATRE PLEIN AIR - ZENITH DE NANCY", "23/06/2017", 40);
        addConcert(5, "TOURS SPEEDWAY - PARC DES EXPOSITIONS DE TOURS", "7/07/2017", 55);
        addConcert(5, "ARENES DE BAYONNE", "25/07/2017", 56);
        addConcert(6, "ZENITH DE TOULOUSE", "16/03/2017", 54);
    }

    private void addConcert(int artistId, String desc, String date, int price) {
        int i = mConcerts.size();
        mConcerts.put(i, new Concert(i, artistId, desc, date, price));
    }
}
