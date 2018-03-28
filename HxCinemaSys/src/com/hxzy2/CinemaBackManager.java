package com.hxzy2;

import java.util.ArrayList;
import java.util.List;

/**
 * ӰѶƽ̨��̨����ϵͳ
 * ���ڹ�����ҵ�ӰԺ
 * @author Administrator
 *
 */
public class CinemaBackManager {
	//���������еĵ�ӰԺ��
	private List<Cinema> cinemaList = new ArrayList<>();
	private List<Film> filmList = new ArrayList<>();//��ǰ������ӳ�ĵ�Ӱ
	
	public CinemaBackManager() {
		Film film1 = new Film();
		film1.setName("��������");
		film1.setType("���顢����");
		film1.setTime(120);
		film1.setLocation("�й���½");
		film1.setDate("2018-01-01");
		film1.setInfo("һ�����˺�һ��Ů�˵Ĺ���");
		
		filmList.add(film1);
		
		Film film2 = new Film();
		film2.setName("������Ϸ");
		film2.setType("���顢����");
		film2.setTime(119);
		film2.setLocation("����");
		film2.setDate("2018-01-05");
		film2.setInfo("�������˺�����Ů�˵Ĺ���");
		
		filmList.add(film2);
		
		Cinema c1 = new Cinema();
		c1.setName("UME");
		
		FilmList filmList = new FilmList();
		filmList.setFilm(film1);
		
		FilmItem item = new FilmItem();
		item.setTime("9:45");
		item.setLanguage("����");
		item.setHourse("1����");
		item.setPrice(28.5);
		filmList.setList(item);
		
		c1.setList(filmList);
		cinemaList.add(c1);
		
		Cinema c2 = new Cinema();
		c2.setName("���Ӱ��");
		

		FilmList filmList2 = new FilmList();
		filmList2.setFilm(film1);
		
		FilmItem item2 = new FilmItem();
		item2.setTime("10:45");
		item2.setLanguage("����");
		item2.setHourse("ĵ����");
		item2.setPrice(28.5);
		filmList2.setList(item2);
		
		c2.setList(filmList2);
		cinemaList.add(c2);
		
	}
	
	/**
	 * ���ӵ�ӰԺ��Ϣ
	 * @param cinema ����̨�����齨�ĵ�ӰԺ��Ϣ
	 * @return -1 ����ʧ�ܣ����ڵ���0��˵�����ӳɹ�
	 */
	public int addCinema(Cinema cinema) {
		return cinemaList.add(cinema) ? 1 : -1;
	}
	
	/**
	 * ���ݵ�ӰԺ���Ʋ�ѯ��ӰԺ����Ϣ
	 * @return
	 */
	public Cinema getCinemaByName(String cinemaName) {
		for (int i = 0; i < cinemaList.size(); i++) {
			Cinema cinema = cinemaList.get(i);
			if (cinema.getName().equals(cinemaName)) {
				return cinema;
			}
		}
		return null;
	}
	
	//2.�������ŵ�Ӱ
	//3.Ϊĳ����ӰԺ���ӵ�Ӱ���ų���Ϣ
	/**
	 * Ϊָ�����Ƶĵ�ӰԺ������ӳ��Ӱ����Ϣ
	 * @param filmList
	 * @return -1 ����ʧ�ܣ����ڵ���0��˵�����ӳɹ�
	 */
	public int addFilmList(Cinema cinema,FilmList filmList) {
		for (int i = 0; i < cinemaList.size(); i++) {
			 Cinema cinema2 = cinemaList.get(i);
			 if (cinema2.equals(cinema)) {
				 cinema2.setList(filmList);
				 return i;
			}
		}
		return -1;
	}
	
	/**
	 * ������ӳ��Ӱ��Ϣ
	 * @param film
	 * @return
	 */
	public int addFilm(Film film) {
		
		return filmList.add(film) ? 1 : -1;
	}
	
	/**
	 * ���ݵ�Ӱ���Ʋ�ѯ��Ӱ��Ϣ
	 * @param filmName
	 * @return
	 */
	public Film getFilmByName(String filmName) {
		for (Film film : filmList) {
			if (film.getName().equals(filmName)) {
				return film;
			}
		}
		return null;
	}
	//4.��ѯ��ǰ��ӳ�ĵ�Ӱ����ʾ���֣����ͣ���ӳʱ��
	//5.���ݵ�Ӱ������ʾ�õ�Ӱ��������Ϣ
	//6.����ӰԺ���ƣ���ѯ��ӰԺ������ӳ�ĵ�Ӱ
	
	/**
	 * ���ݵ�Ӱ����ȡ������ӳ�õ�Ӱ�ĵ�ӰԺ
	 * @param film
	 * @return
	 */
	public List<Cinema> getCinemaByFilm(Film film) {
	
		List<Cinema> newList = new ArrayList<>();//���������ӳ�õ�Ӱ�ĵ�ӰԺ
		
		int index = 0;
		for (int i = 0; i < cinemaList.size(); i++) {//���ѭ����ѭ�����е�ӰԺ
			//�ڲ�ѭ��������ÿ�ҵ�ӰԺ����ӳ�ĵ�Ӱ��Ϣ�࣬�жϸö����Ƿ����
			Cinema cinema = cinemaList.get(i);
			for (int j = 0; j < cinema.getList().size(); j++) {
				FilmList filmList = cinema.getList().get(j);
				if (filmList == null) {
					break;
				}
				if (filmList.getFilm() == film) { //�Ƚ��ڴ��ַ
					newList.add(cinema);
				}
			}
		}
		return newList;
	}
}