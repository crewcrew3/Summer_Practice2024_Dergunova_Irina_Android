package ru.itis.myapplication2.recycler_view

//это класс является синглтоном(т.е. имеет один конкретный экземпляр.
//Его задача в том, чтобы предоставить нам список произведений японской мультипликации)

object AnimeRepository {

    val animes: List<Anime> = listOf(
        Anime(
            id = 1,
            name = "Spirited Away",
            genres = "Fantasy, adventure, drama",
            url = "https://life4health.ru/wp-content/uploads/2018/10/Unesennye-prizrakami_003.jpg",
            shortDescription = "A girl named Chihiro finds herself in a magical world and has to work at a hotel for spirits to save her parents from witchcraft.",
            longDescription = "Chihiro Ogino, a ten-year-old girl, gets lost with her parents while moving to a new home. They stumble upon an abandoned amusement park and enter a strange world inhabited by spirits. Chihiro's parents are turned into pigs by the witch Yubaba, and Chihiro must work in Yubaba's bathhouse to free them. She befriends a mysterious boy named Haku, who helps her navigate the spirit world and find her way home.",
        ),
        Anime(
            id = 2,
            name = "Howl's Moving Castle",
            genres = "Romance, drama, steampunk, adventure",
            url = "https://i.ebayimg.com/images/g/780AAOSw6wtjZEv0/s-l1600.jpg",
            shortDescription = "The young hatter Sophie is cursed by a witch and turns into an old woman. She seeks help from the mysterious wizard Howl, who lives in a Walking Castle.",
            longDescription = "Sophie Hatter, a young woman working in a hat shop, is cursed by the Witch of the Waste and turns into an old woman. She leaves home and meets the wizard Howl, who takes her in and hides her from the Witch. Howl lives in a moving castle with his apprentice, Markl, and a fire demon named Calcifer. Sophie and Howl form a bond, and Sophie learns about Howl's past and his involvement in a war between two neighboring countries.",
        ),
        Anime(
            id = 3,
            name = "Code Geass",
            genres = "Science fiction, mecha, adventure",
            url = "https://kartinki.pics/uploads/posts/2021-07/1625738950_19-kartinkin-com-p-kod-gias-oboi-krasivie-20.jpg",
            shortDescription = "Lelouch Lamperouge receives a mysterious power known as Gias, which allows him to control people. He uses this power to create a new world.",
            longDescription = "Lelouch Lamperouge is a British prince who was exiled to Japan after his mother's assassination. He attends Ashford Academy, where he meets C.C., a mysterious woman who grants him the power of Geass. Geass allows Lelouch to control people's minds by making eye contact with them. Lelouch uses this power to start a rebellion against the Holy Britannian Empire, which has conquered Japan.",
        ),
        Anime(
            id = 4,
            name = "Black Butler",
            genres = "Mystery, detective, drama",
            url = "https://virtus-img.cdnvideo.ru/images/og-jpg/plain/28/28c1b930-b37e-49f6-b395-0697cabdff48.jpg",
            shortDescription = "A 12-year-old earl named Ciel Phantomhive makes a contract with a demon named Sebastian Michaelis to avenge the death of his parents.",
            longDescription = "Ciel Phantomhive is a young boy who becomes the head of the Phantomhive family after his parents are murdered. He makes a contract with a demon named Sebastian Michaelis, who agrees to serve him as his butler and help him find his parents' killers. Sebastian will do whatever Ciel asks him to do. Ciel and Sebastian investigate a series of mysterious crimes and uncover a conspiracy that threatens the very existence of England.",
        ),
        Anime(
            id = 5,
            name = "Pandora Hearts",
            genres = "Mystery, adventure, tragedy",
            url = "https://img.goodfon.ru/original/2160x1620/6/ae/badfon-pandora-hearts-alice-gilbert.jpg",
            shortDescription = "Oz Vessalius is sent to the Abyss to save his friend Gilbert Nightray from a mysterious organization.",
            longDescription = "Oz Vessalius is a young man who is framed for a crime he did not commit and is sent to the Abyss, a prison for the living dead. In the Abyss, Oz meets Alice, a girl who has lost her memories. Together, they travel through the Abyss and uncover the secrets of the organization that framed Oz. Oz learns that he is the heir to the Vessalius family, a powerful clan of sorcerers. He also learns that Alice is the key to defeating the organization and saving the world from destruction.",
        ),
        Anime(
            id = 6,
            name = "Lookism",
            genres = "Comedy, drama, martial arts, gang",
            url = "https://pic.rutubelist.ru/video/78/2b/782b26e4df6d0afb617fd7c861cf9e43.jpg",
            shortDescription = "An overweight high school student wakes up one day in the body of a handsome boy, and he must learn to navigate his new life and uncover the secrets of his transformation.",
            longDescription = "Park Hyung-seok is an overweight high school student who is constantly bullied by his classmates. One day, he wakes up in the body of a handsome boy named Lee Jin-ho. Hyung-seok is initially thrilled with his new body, but he soon realizes that it comes with its own set of challenges. Hyung-seok uncovers a secret organization that is experimenting on people's bodies. He must use his new body to fight against this organization and protect his friends and family.",
        ),
        Anime(
            id = 7,
            name = "K-Project",
            genres = "Drama, action, science fiction",
            url = "https://pibig.info/uploads/posts/2021-04/1619002309_4-pibig_info-p-anime-proekt-kei-anime-krasivo-5.jpg",
            shortDescription = "In a futuristic city, people with superpowers known as \"Projects\" live alongside ordinary humans.",
            longDescription = "The story follows three high school students: Kuroh Yatogami, Neko Sakuragi, and Isana Yashiro. Kuroh is a Project who works for a secret organization known as Scepter 4, which is responsible for maintaining order in the city. Neko is a Project who has the ability to control fire. Isana is a Project who has the ability to heal others. The three of them become involved in a conflict between two rival factions of Projects, and they must learn to control their powers and uncover the secrets of their own origins.",
        ),
    )
}