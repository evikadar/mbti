package service;

import model.BlogPost;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BlogService {
    public static List<BlogPost> findEveryPost() {
        List<BlogPost> allPosts = new ArrayList<>();

        BlogPost one = new BlogPost("Pogány Csörsz", "What If", LocalDate.now(), "what if angels in their “true” forms are actually more terrifying than demons because demons reflect human sins and fears but angels are so entirely other and alien from us as to be truly eldritch.", "url1");
        BlogPost two = new BlogPost("Pogány Csörsz", "Shouldnt", LocalDate.now(), "I’m gonna be real with all of you. Immigration laws shouldn’t exist. People should be allowed to visit and live in any country they like without having to take years of testing to ‘prove’ they care about the country or the government or some dumb bullshit. Most born Americans don’t even know what’s in the bill of rights aside from the first couple amendments, and when that shit was written it didn’t consider anyone who was nonwhite and or a woman as a person deserving rights so. It’s all a sack of crap anyway. “Free country” is also bullshit because if it were really free anyone could live here without fearing for their life or the lives of their children without having to sign a bunch of papers in a complicated language they don’t know that was design to fail them. This country has always been shit and immigration laws have always been shit and they’re built on racism full stop. And anyone who argues that immigration laws aren’t inherently racist and inhumane is a big ass bootlicker. End post.", "url2");
        BlogPost three = new BlogPost("Pogány Csörsz", "types of people as environments", LocalDate.now(), "sea: wild hair, iced coffee, probably listens to billie eilish, great instagram, wears bracelets/anklets, was that kid that thought they had some authority on greek mythology bc they read the percy jackson books, seems like they have their life together but actually are lowkey falling apart, can vibe w/ anyone\n" +
                "\n" +
                "forest: hot coffee, guitar/indie/folk music, runs an aesthetic blog, doesn’t tell anyone what their favorite songs are bc that’s Too Personal, absolutely has to put fairy lights everywhere, loves their friends and makes sure they know it, if you hurt them they won’t do anything back they’ll just leave without a word or a trace\n" +
                "\n" +
                "desert: long road trips, retro diners at 2am, also eats a lot of fast food, nothing fazes them, drunk declarations of love, their hair is their personality, thrives during nighttime, bored eater, acts chill and will say they’re Fine as they lay face down on the floor but also will tell their life story after 10pm\n" +
                "\n" +
                "mountains: hot chocolate, gorgeous hair, adrenaline junkie, has a lot of secrets/emotional depth, morning person, will go insane if they’re cooped up indoors for too long, complete 180 from the person their 12-year-old self thought they would be but thank god for that\n" +
                "\n" +
                "meadow: softie, henna tattoos, puts flowers in their hair, sparkling water, pastels, likes taylor swift, barely knows how to drive, good at drawing/painting, doesn’t hide their feelings, ppl think their openness can be taken advantage of but they see your motives and Know What You’re Trying To Do\n" +
                "\n" +
                "tundra: flawless eyebrows, wears lots of dark colors, thick skin, intense as hell but it’s cool, eyes that stare into your fricken soul, seems emotionally unavailable but actually secretly loves a lot of people and is scared of losing them but will never show it\n" +
                "\n" +
                "lake: iced tea, lives at chipotle, hands and feet are always cold, completely screwed up spotify algorithm, hates days when they can’t see the sun, loves spring/summer, really just wants to Calm Down, niche humor, has been saying they’re dead inside since 2014", "url3");

        allPosts.add(one);
        allPosts.add(two);
        allPosts.add(three);

        return allPosts;
    }

    public void getFirstThreePosts() {

    }

    public void getPostsByPages(int pageNumber) {

    }

    public void getPostNumberByMonths() {

    }

    public void saveNewBlogPost(BlogPost newPost) {

    }

    public void createNewUrlFromTitle(BlogPost post) {
        String title = post.getTitle();
    }


}
