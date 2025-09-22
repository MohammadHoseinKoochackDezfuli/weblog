function timeDiffString(isoString) {
    const now = new Date();
    const past = new Date(isoString);
    let diff = Math.floor((now - past) / 1000);
    const years = Math.floor(diff / (3600*24*30*12));
    diff -= years * 3600 * 24 * 30 * 12;
    const months = Math.floor(diff / (3600*24*30));
    diff -= months * 3600 * 24 * 30;
    const days = Math.floor(diff / (3600*24));
    diff -= days * 3600 * 24;
    const hours = Math.floor(diff / 3600);
    diff -= hours * 3600;
    const minutes = Math.floor(diff / 60);
    const seconds = diff - minutes * 60;

    if (years > 0) return `${years} سال و ${months} ماه پیش`;
    if (months > 0) return `${months} ماه و ${days} روز پیش`;
    if (days > 0) return `${days} روز و ${hours} ساعت پیش`;
    if (hours > 0) return `${hours} ساعت و ${minutes} دقیقه پیش`;
    if (minutes > 0) return `${minutes} دقیقه و ${seconds} ثانیه پیش`;
    return "کمتر از 1 دقیقه پیش";
}