export enum SocialMediaEnum {
    WHATSAPP = 'whatsapp',
    TWITTER = 'twitter',
    FACEBOOK = 'facebook',
    INSTAGRAM = 'instagram',
    WEB = 'web'
}

export class SocialMedia {
    /**
     * Get by enum
     */
    public static getByEnum(enumString: SocialMediaEnum): SocialMedia {
        return SocialMedia.lista.find(t => t.enumString === enumString);
    }

    public static getByName(name: String): SocialMedia {
        return SocialMedia.lista.find(t => t.name === name);
    }

    /**
     * Get by id
     */
    public static getById(id: number): SocialMedia {
        return SocialMedia.lista.find(t => t.id === id);
    }

    public static readonly lista: SocialMedia[] = [
        {
            enumString: SocialMediaEnum.WHATSAPP,
            id: 1,
            name: 'whatsapp'
        },
        {
            enumString: SocialMediaEnum.TWITTER,
            id: 2,
            name: 'twitter'
        },
        {
            enumString: SocialMediaEnum.FACEBOOK,
            id: 3,
            name: 'facebook'
        },
        {
            enumString: SocialMediaEnum.INSTAGRAM,
            id: 4,
            name: 'instagram'
        },
        {
            enumString: SocialMediaEnum.WEB,
            id: 5,
            name: 'web'
        }
    ];

    constructor(public enumString: SocialMediaEnum, public id: number, public name: string) {}
}
