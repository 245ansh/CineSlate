package com.cineslate.CineSlate.apiThings.search;
import java.util.ArrayList;
import java.util.List;

public class Datum {
    private List<String> aliases = new ArrayList<String>();
    private List<String> companies = new ArrayList<String>();
    private String companyType;
    private String country;
    private String director;
    private String firstAirTime;
    private List<String> genres = new ArrayList<String>();
    private String id;
    private String image_url;
    private String name;
    private Boolean isOfficial;
    private String nameTranslated;
    private String network;
    private String objectID;
    private String officialList;
    private String overview;
    private Overviews overviews;
    private List<String> overviewTranslated = new ArrayList<String>();
    private String poster;
    private List<String> posters = new ArrayList<String>();
    private String primaryLanguage;
    private List<RemoteId> remoteIds = new ArrayList<RemoteId>();
    private String status;
    private String slug;
    private List<String> studios = new ArrayList<String>();
    private String title;
    private String thumbnail;
    private Translations translations;
    private List<String> translationsWithLang = new ArrayList<String>();
    private String tvdb_id;
    private String type;
    public String getTvdb_id() {
        return tvdb_id;
    }
    public void setTvdb_id(String tvdb_id) {
        this.tvdb_id = tvdb_id;
    }
    private String year;
    public List<String> getAliases() {
        return aliases;
    }
    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }
    public List<String> getCompanies() {
        return companies;
    }
    public void setCompanies(List<String> companies) {
        this.companies = companies;
    }
    public String getCompanyType() {
        return companyType;
    }
    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getFirstAirTime() {
        return firstAirTime;
    }
    public void setFirstAirTime(String firstAirTime) {
        this.firstAirTime = firstAirTime;
    }
    public List<String> getGenres() {
        return genres;
    }
    public void setGenres(List<String> genres) {
        this.genres = genres;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Boolean getIsOfficial() {
        return isOfficial;
    }
    public void setIsOfficial(Boolean isOfficial) {
        this.isOfficial = isOfficial;
    }
    public String getNameTranslated() {
        return nameTranslated;
    }
    public void setNameTranslated(String nameTranslated) {
        this.nameTranslated = nameTranslated;
    }
    public String getNetwork() {
        return network;
    }
    public void setNetwork(String network) {
        this.network = network;
    }
    public String getObjectID() {
        return objectID;
    }
    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }
    public String getOfficialList() {
        return officialList;
    }
    public void setOfficialList(String officialList) {
        this.officialList = officialList;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public Overviews getOverviews() {
        return overviews;
    }
    public void setOverviews(Overviews overviews) {
        this.overviews = overviews;
    }
    public List<String> getOverviewTranslated() {
        return overviewTranslated;
    }
    public void setOverviewTranslated(List<String> overviewTranslated) {
        this.overviewTranslated = overviewTranslated;
    }
    public String getPoster() {
        return poster;
    }
    public void setPoster(String poster) {
        this.poster = poster;
    }
    public List<String> getPosters() {
        return posters;
    }
    public void setPosters(List<String> posters) {
        this.posters = posters;
    }
    public String getPrimaryLanguage() {
        return primaryLanguage;
    }
    public void setPrimaryLanguage(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
    }
    public List<RemoteId> getRemoteIds() {
        return remoteIds;
    }
    public void setRemoteIds(List<RemoteId> remoteIds) {
        this.remoteIds = remoteIds;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getSlug() {
        return slug;
    }
    public void setSlug(String slug) {
        this.slug = slug;
    }
    public List<String> getStudios() {
        return studios;
    }
    public void setStudios(List<String> studios) {
        this.studios = studios;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
    public Translations getTranslations() {
        return translations;
    }
    public void setTranslations(Translations translations) {
        this.translations = translations;
    }
    public List<String> getTranslationsWithLang() {
        return translationsWithLang;
    }
    public void setTranslationsWithLang(List<String> translationsWithLang) {
        this.translationsWithLang = translationsWithLang;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }
    public String getImage_url() {
        return image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

}
