package himedia.photobook.repositories;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class voConfiguration {
	/**
	 * 앨범의 재질들을 등록해둔 enum
	 * */
	private enum ALBUM_MATERIAL{
		LINEN, LEATHER, HARD, SOFT
	};
	
	private enum ALBUM_COLOR{
		GRAY, BLUE, BROWN
	};
	private enum ALBUM_SIZE{
		S, M, L
	};

	/**
	 * 앨범의 재질의 속성들을 List로 들고 오는 메서드
	 * */
	public List<String> getAlbumMaterialList() {
		List<String> materialList = Stream.of(ALBUM_MATERIAL.values())
				.map(Enum::name).collect(Collectors.toList());
		
		return materialList;
	}
}
